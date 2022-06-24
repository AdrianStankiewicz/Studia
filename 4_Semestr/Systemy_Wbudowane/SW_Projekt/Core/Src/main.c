/* USER CODE BEGIN Header */
/**
  ******************************************************************************
  * @file           : main.c
  * @brief          : Main program body
  ******************************************************************************
  * @attention
  *
  * <h2><center>&copy; Copyright (c) 2022 STMicroelectronics.
  * All rights reserved.</center></h2>
  *
  * This software component is licensed by ST under BSD 3-Clause license,
  * the "License"; You may not use this file except in compliance with the
  * License. You may obtain a copy of the License at:
  *                        opensource.org/licenses/BSD-3-Clause
  *
  ******************************************************************************
  */
/* USER CODE END Header */
/* Includes ------------------------------------------------------------------*/
#include "main.h"
#include "characters.h"

/* Private includes ----------------------------------------------------------*/
/* USER CODE BEGIN Includes */

/* USER CODE END Includes */

/* Private typedef -----------------------------------------------------------*/
/* USER CODE BEGIN PTD */

/* USER CODE END PTD */

/* Private define ------------------------------------------------------------*/
/* USER CODE BEGIN PD */
#define TFT_WIDTH 320
#define TFT_HEIGHT 240
#define TFT_HALF_HEIGHT 120

#define TFT_BLUE    0x1F00
#define TFT_RED     0x00F8
#define TFT_GREEN   0xE007

#define BLACK       	0x0000
#define NAVY        	0x0F00
#define DARKGREEN   	0xE003
#define DARKCYAN    	0xEF03
#define MAROON      	0x0078
#define PURPLE      	0x0F78
#define OLIVE       	0xE07B
#define LIGHTGREY   	0x18C6
#define DARKGREY    	0xEF7B
#define BLUE        	0x1F00
#define GREEN       	0xE007
#define CYAN        	0xFF07
#define RED         	0x00F8
#define MAGENTA     	0x1FF8
#define YELLOW      	0xE0FF
#define WHITE       	0xFFFF
#define ORANGE      	0x20FD
#define GREENYELLOW 	0xE5AF
#define PINK        	0x1FF8
/* USER CODE END PD */

/* Private macro -------------------------------------------------------------*/
/* USER CODE BEGIN PM */

/* USER CODE END PM */

/* Private variables ---------------------------------------------------------*/
I2C_HandleTypeDef hi2c2;

SPI_HandleTypeDef hspi1;

/* USER CODE BEGIN PV */
uint8_t val, data, dzientyg, rec_buf[16];
uint8_t sek, sekundy=0, sekundy1=0, sekundy2=0, sec=0;
uint8_t minuty=0, minuty1=0, minuty2=0, min=0;
uint8_t godziny=0, godziny1=0, godziny2=0, godz=0;
uint8_t dzien, dni1=0, dni2;
uint8_t miesiac, mies1=0, mies2;
uint8_t rok, rok1=0, rok2;
char sec1, sec2, godz1, godz2, min1, min2;
char dnic1, dnic2, miesc1, miesc2, rokc1, rokc2;

uint8_t sekSt=0x15, minSt=0x30, godzSt=0x12, dniSt=0x09, miesSt=0x06, rokSt=0x22;

uint16_t  dev_addr = 0xD0;
uint16_t  mem_addr = 0;
uint16_t  mem_addr_size =1;
uint8_t   data = 0;
uint16_t  data_size =1;
uint8_t buffer[17]={0x00,0x41,0x42,0x43,0x44,0x45,0x46,0x47,0x48,0x49,0x4A,0x4B,0x4C,0x4D,0x4E,0x4F,0x50};
uint32_t timeout = 100;
/* USER CODE END PV */

/* Private function prototypes -----------------------------------------------*/
void SystemClock_Config(void);
static void MX_GPIO_Init(void);
static void MX_SPI1_Init(void);
static void MX_I2C2_Init(void);
/* USER CODE BEGIN PFP */

uint8_t Buffer[8];
uint8_t field = 0x00;

uint16_t year( uint8_t year ) { return 2000U + year; };

uint8_t ReadRegister( uint8_t reg )
{
	uint8_t val;
	HAL_I2C_Master_Transmit(&hi2c2, 0x68 << 1, &reg, 1, HAL_MAX_DELAY);
	HAL_I2C_Master_Receive(&hi2c2, 0x68 << 1, &val, 1, HAL_MAX_DELAY);
	return val;
}

/* USER CODE END PFP */

/* Private user code ---------------------------------------------------------*/
/* USER CODE BEGIN 0 */
void write_cmd(uint8_t cmd)
{
	//dc = 0;
	//komendy dla sterownika TFT  podaje się w stanie niskim linii DC
    HAL_GPIO_WritePin(DC_GPIO_Port, DC_Pin, 0);
    HAL_SPI_Transmit(&hspi1, &cmd, 1, 1);
}
void write_data(uint8_t data)
{
	//dc = 1;
	////dane do wyświetlenia  podaje się w stanie wysokim linii DC
	HAL_GPIO_WritePin(DC_GPIO_Port, DC_Pin, 1);
	HAL_SPI_Transmit(&hspi1, &data, 1, 1);
}

void tft_reset()
{
    //wait_ms(200);
    HAL_Delay(200);
    //cs = 1;
    HAL_GPIO_WritePin(CS_GPIO_Port, CS_Pin, 1);
    //dc = 1;
    HAL_GPIO_WritePin(DC_GPIO_Port, DC_Pin, 1);
    //rst = 1;
    HAL_GPIO_WritePin(RESET_GPIO_Port, RESET_Pin, 1);
    //wait_ms(200);
    HAL_Delay(200);
    //rst = 0;
    HAL_GPIO_WritePin(RESET_GPIO_Port, RESET_Pin, 0);
    //wait_us(10);
    HAL_Delay(1);

    //rst = 1;
    HAL_GPIO_WritePin(RESET_GPIO_Port, RESET_Pin, 1);
    //wait_ms(120);
    HAL_Delay(120);
    //cs = 0;
    HAL_GPIO_WritePin(CS_GPIO_Port, CS_Pin, 0);
    //wait_ms(10);
    HAL_Delay(10);

    write_cmd(0x3A); // wybór formatu i rozdzielczości kolorów
    write_data(0x55); // 16bit Color

    write_cmd(0xB1); // wybór częstotliwości odświeżania
    write_data(0);
    write_data(0x1f);//0x001f  mała częstotliwość odświeżania

    write_cmd(0x36); // Memory Access Control
    write_data(0xE8); // MY MX MV BGR

    write_cmd(0x11); // Sleep Out
    //wait_ms(5);
    HAL_Delay(5);

    write_cmd(0x29); // Display On
}




void tft_set_window(uint16_t x0, uint16_t y0, uint16_t x1, uint16_t y1)
{
  write_cmd(0x2A); // Column Address Set
  write_data(x0 >> 8);
  write_data(x0);
  write_data(x1 >> 8);
  write_data(x1);

  write_cmd(0x2B); // Page Address Set
  write_data(y0 >> 8);
  write_data(y0);
  write_data(y1 >> 8);
  write_data(y1);

  write_cmd(0x2C); // Memory Write

  HAL_Delay(1);
}

void tft_clear(uint16_t color)
{
	tft_set_window(0, 0, TFT_WIDTH, TFT_HEIGHT);
	uint8_t  c1 = color & 0xff;//młodsze 8 bitów zmiennej color
	uint8_t  c2 = color >>8;////starsze 8 bitów zmiennej color
	for (int i = 0; i < TFT_WIDTH * TFT_HEIGHT; ++i)
	{
		write_data(c1);
		write_data(c2);
	}
}

void tft_clear_half(uint16_t color1, uint16_t color2)
{
	tft_set_window(0, 0, TFT_WIDTH, TFT_HEIGHT);
	uint8_t  c1 = color1 & 0xff;//młodsze 8 bitów zmiennej color
	uint8_t  c2 = color1 >>8;////starsze 8 bitów zmiennej color
	for (int i = 0; i < (TFT_WIDTH * TFT_HEIGHT)/2; ++i)
	{
		write_data(c1);
		write_data(c2);
	}

	uint8_t c3 = color2 & 0xff;//młodsze 8 bitów zmiennej color
	uint8_t c4 = color2 >>8;////starsze 8 bitów zmiennej color
	for (int i = (TFT_WIDTH * TFT_HEIGHT)/2; i < TFT_WIDTH * TFT_HEIGHT; ++i)
	{
		write_data(c3);
		write_data(c4);
	}
}

void tft_clear_square(uint16_t color)
{
	tft_set_window(60, 60, TFT_WIDTH-60, TFT_HEIGHT-60);
	uint8_t  c1 = color & 0xff;//młodsze 8 bitów zmiennej color
	uint8_t  c2 = color >>8;////starsze 8 bitów zmiennej color
	for (int i = 0; i < TFT_WIDTH * TFT_HEIGHT; ++i)
	{
		write_data(c1);
		write_data(c2);
	}
}

void ILI9341_Draw_Char(int x, int y, unsigned int color, unsigned int phone, unsigned char charcode, unsigned char size)
{
	int i,h;

	switch(size)
	{
		case 1:
			tft_set_window(x, y, x+5, y+8);

			for(h=0;h<8;h++)
			{
				for(i=2;i<8;i++)
				{
					if ((chars8[charcode-0x20][h]>>(7-i))&0x01)
					{
						   uint8_t  c1 = color & 0xff;
						   uint8_t  c2 = color >>8;
						   write_data(c1);//młodsze 8 bitów zmiennej color
						   write_data(c2);//starsze 8 bitów zmiennej color
					}
					else
					{
						   uint8_t  p1 = phone & 0xff;//tło
						   uint8_t  p2 = phone >>8;

						   write_data(p1);//młodsze 8 bitów zmiennej phone (tło)
						   write_data(p2);//starsze 8 bitów zmiennej phone (tło)
					}
				}
			}
			break;
		case 2:
			tft_set_window(x, y, x+7, y+16);

			for(h=0;h<16;h++)
			{
				for(i=0;i<8;i++)
				{
					if ((chars16[charcode-0x20][h]>>(7-i))&0x01)
					{
						uint8_t  c1 = color & 0xff;
						uint8_t  c2 = color >>8;
						write_data(c1);//młodsze 8 bitów zmiennej color
						write_data(c2);//starsze 8 bitów zmiennej color
					}
					else
					{
						uint8_t  p1 = phone & 0xff;
						uint8_t  p2 = phone >>8;
						write_data(p1);//młodsze 8 bitów zmiennej phone (tło)
							write_data(p2);//starsze 8 bitów zmiennej phone (tło)
					}
				}
			}
		break;
	}
}
/* USER CODE END 0 */

/**
  * @brief  The application entry point.
  * @retval int
  */
int main(void)
{
  /* USER CODE BEGIN 1 */

  /* USER CODE END 1 */

  /* MCU Configuration--------------------------------------------------------*/

  /* Reset of all peripherals, Initializes the Flash interface and the Systick. */
  HAL_Init();

  /* USER CODE BEGIN Init */

  /* USER CODE END Init */

  /* Configure the system clock */
  SystemClock_Config();

  /* USER CODE BEGIN SysInit */

  /* USER CODE END SysInit */

  /* Initialize all configured peripherals */
  MX_GPIO_Init();
  MX_SPI1_Init();
  MX_I2C2_Init();
  /* USER CODE BEGIN 2 */

  	tft_reset();

  	HAL_I2C_Mem_Write(&hi2c2, dev_addr, mem_addr, mem_addr_size, &sekSt, 16, HAL_MAX_DELAY);
  	HAL_I2C_Mem_Write(&hi2c2, dev_addr, mem_addr+1, mem_addr_size, &minSt, 16, HAL_MAX_DELAY);
  	HAL_I2C_Mem_Write(&hi2c2, dev_addr, mem_addr+2, mem_addr_size, &godzSt, 16, HAL_MAX_DELAY);
  	HAL_I2C_Mem_Write(&hi2c2, dev_addr, mem_addr+4, mem_addr_size, &dniSt, 16, HAL_MAX_DELAY);
  	HAL_I2C_Mem_Write(&hi2c2, dev_addr, mem_addr+5, mem_addr_size, &miesSt, 16, HAL_MAX_DELAY);
  	HAL_I2C_Mem_Write(&hi2c2, dev_addr, mem_addr+6, mem_addr_size, &rokSt, 16, HAL_MAX_DELAY);

    write_cmd(0x36);
    write_data(0x28);//0b MY MX MV ML RGB=1 MH 0 0
    //write_data(0xe8);
    //write_data(0x38);
    //write_data(0x68);
    //write_data(0xa8);


    tft_clear(BLACK);
    //tft_clear(RED);


    //tft_clear_half(YELLOW, BLUE);

    //tft_clear_square(RED);
    //tft_clear(RED);

    //ILI9341_Draw_Char(50, 50, GREEN, BLACK, 'a', 2);

	HAL_Delay(100);
	HAL_I2C_Mem_Write(&hi2c2, dev_addr, mem_addr, mem_addr_size, &data, data_size, HAL_MAX_DELAY);
	HAL_I2C_Master_Transmit(&hi2c2, dev_addr, buffer, 2, HAL_MAX_DELAY);
	HAL_Delay(100);

  /* USER CODE END 2 */

  /* Infinite loop */
  /* USER CODE BEGIN WHILE */
  while (1)
  {
    /* USER CODE END WHILE */

    /* USER CODE BEGIN 3 */
	  HAL_I2C_Mem_Read(&hi2c2, dev_addr, mem_addr, mem_addr_size, rec_buf, 16, HAL_MAX_DELAY);
	  HAL_I2C_Master_Transmit(&hi2c2, dev_addr, &data, data_size, timeout);
	  HAL_I2C_Master_Receive(&hi2c2, dev_addr, &sekundy, data_size, timeout);

	  sec = rec_buf[0];
	  sekundy1 = sec & 0b00001111;
	  sec = sec >> 4;
	  sekundy2 = sec & 0b00001111;

	  min = rec_buf[1];
	  minuty1 = min & 0b00001111;
	  min = min >> 4;
	  minuty2 = min & 0b00001111;

	  godz = rec_buf[2];
	  godziny1 = godz & 0b00001111;
	  godz = godz >> 4;
	  godziny2 = godz & 0b00001111;

	  sec1 = sekundy1 + '0';
	  sec2 = sekundy2 + '0';

	  min1 = minuty1 + '0';
	  min2 = minuty2 + '0';

	  godz1 = godziny1 + '0';
	  godz2 = godziny2 + '0';

	  ILI9341_Draw_Char(120, 100, GREEN, BLACK, godz2, 2);
	  ILI9341_Draw_Char(140, 100, GREEN, BLACK, godz1, 2);

	  ILI9341_Draw_Char(160, 100, GREEN, BLACK, 58, 2);

	  ILI9341_Draw_Char(180, 100, GREEN, BLACK, min2, 2);
	  ILI9341_Draw_Char(200, 100, GREEN, BLACK, min1, 2);

	  ILI9341_Draw_Char(220, 100, GREEN, BLACK, 58, 2);

	  ILI9341_Draw_Char(240, 100, GREEN, BLACK, sec2, 2);
	  ILI9341_Draw_Char(260, 100, GREEN, BLACK, sec1, 2);

	  HAL_Delay(50);

	  dzien = rec_buf[4];
	  dni1 = dzien & 0b00001111;
	  dzien = dzien >> 4;
	  dni2 = dzien & 0b00001111;

	  miesiac = rec_buf[5];

	  if(miesiac == 0x01) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'J', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'A', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'N', 2);
	  }
	  else if(miesiac == 0x02) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'F', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'E', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'B', 2);
	  }
	  else if(miesiac == 0x03) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'M', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'A', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'R', 2);
	  }
	  else if(miesiac == 0x04) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'A', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'P', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'R', 2);
	  }
	  else if(miesiac == 0x05) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'M', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'A', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'Y', 2);
	  }
	  else if(miesiac == 0x06) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'J', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'U', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'N', 2);
	  }
	  else if(miesiac == 0x07) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'J', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'U', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'L', 2);
	  }
	  else if(miesiac == 0x08) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'A', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'U', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'G', 2);
	  }
	  else if(miesiac == 0x09) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'S', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'E', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'P', 2);
	  }
	  else if(miesiac == 0x10) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'O', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'C', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'T', 2);
	  }
	  else if(miesiac == 0x11) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'N', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'O', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'V', 2);
	  }
	  else if(miesiac == 0x12) {
		  ILI9341_Draw_Char(180, 160, GREEN, BLACK, 'D', 2);
		  ILI9341_Draw_Char(200, 160, GREEN, BLACK, 'E', 2);
		  ILI9341_Draw_Char(220, 160, GREEN, BLACK, 'C', 2);
	  }


//	  mies1 = miesiac & 0b00001111;
//	  miesiac = miesiac >> 4;
//	  mies2 = miesiac & 0b00001111;

	  rok = rec_buf[6];
	  rok1 = rok & 0b00001111;
	  rok = rok >> 4;
	  rok2 = rok & 0b00001111;

	  dnic1 = dni1 + '0';
	  dnic2 = dni2 + '0';

	  miesc1 = mies1 + '0';
	  miesc2 = mies2 + '0';

	  rokc1 = rok1 + '0';
	  rokc2 = rok2 + '0';

	  ILI9341_Draw_Char(120, 160, GREEN, BLACK, dnic2, 2);
	  ILI9341_Draw_Char(140, 160, GREEN, BLACK, dnic1, 2);

	  ILI9341_Draw_Char(260, 160, GREEN, BLACK, rokc2, 2);
	  ILI9341_Draw_Char(280, 160, GREEN, BLACK, rokc1, 2);
  }
  /* USER CODE END 3 */
}

/**
  * @brief System Clock Configuration
  * @retval None
  */
void SystemClock_Config(void)
{
  RCC_OscInitTypeDef RCC_OscInitStruct = {0};
  RCC_ClkInitTypeDef RCC_ClkInitStruct = {0};

  /** Configure the main internal regulator output voltage
  */
  __HAL_RCC_PWR_CLK_ENABLE();
  __HAL_PWR_VOLTAGESCALING_CONFIG(PWR_REGULATOR_VOLTAGE_SCALE3);
  /** Initializes the RCC Oscillators according to the specified parameters
  * in the RCC_OscInitTypeDef structure.
  */
  RCC_OscInitStruct.OscillatorType = RCC_OSCILLATORTYPE_HSI;
  RCC_OscInitStruct.HSIState = RCC_HSI_ON;
  RCC_OscInitStruct.HSICalibrationValue = RCC_HSICALIBRATION_DEFAULT;
  RCC_OscInitStruct.PLL.PLLState = RCC_PLL_NONE;
  if (HAL_RCC_OscConfig(&RCC_OscInitStruct) != HAL_OK)
  {
    Error_Handler();
  }
  /** Initializes the CPU, AHB and APB buses clocks
  */
  RCC_ClkInitStruct.ClockType = RCC_CLOCKTYPE_HCLK|RCC_CLOCKTYPE_SYSCLK
                              |RCC_CLOCKTYPE_PCLK1|RCC_CLOCKTYPE_PCLK2;
  RCC_ClkInitStruct.SYSCLKSource = RCC_SYSCLKSOURCE_HSI;
  RCC_ClkInitStruct.AHBCLKDivider = RCC_SYSCLK_DIV1;
  RCC_ClkInitStruct.APB1CLKDivider = RCC_HCLK_DIV1;
  RCC_ClkInitStruct.APB2CLKDivider = RCC_HCLK_DIV1;

  if (HAL_RCC_ClockConfig(&RCC_ClkInitStruct, FLASH_LATENCY_0) != HAL_OK)
  {
    Error_Handler();
  }
}

/**
  * @brief I2C2 Initialization Function
  * @param None
  * @retval None
  */
static void MX_I2C2_Init(void)
{

  /* USER CODE BEGIN I2C2_Init 0 */

  /* USER CODE END I2C2_Init 0 */

  /* USER CODE BEGIN I2C2_Init 1 */

  /* USER CODE END I2C2_Init 1 */
  hi2c2.Instance = I2C2;
  hi2c2.Init.ClockSpeed = 100000;
  hi2c2.Init.DutyCycle = I2C_DUTYCYCLE_2;
  hi2c2.Init.OwnAddress1 = 0;
  hi2c2.Init.AddressingMode = I2C_ADDRESSINGMODE_7BIT;
  hi2c2.Init.DualAddressMode = I2C_DUALADDRESS_DISABLE;
  hi2c2.Init.OwnAddress2 = 0;
  hi2c2.Init.GeneralCallMode = I2C_GENERALCALL_DISABLE;
  hi2c2.Init.NoStretchMode = I2C_NOSTRETCH_DISABLE;
  if (HAL_I2C_Init(&hi2c2) != HAL_OK)
  {
    Error_Handler();
  }
  /** Configure Analogue filter
  */
  if (HAL_I2CEx_ConfigAnalogFilter(&hi2c2, I2C_ANALOGFILTER_ENABLE) != HAL_OK)
  {
    Error_Handler();
  }
  /** Configure Digital filter
  */
  if (HAL_I2CEx_ConfigDigitalFilter(&hi2c2, 0) != HAL_OK)
  {
    Error_Handler();
  }
  /* USER CODE BEGIN I2C2_Init 2 */

  /* USER CODE END I2C2_Init 2 */

}

/**
  * @brief SPI1 Initialization Function
  * @param None
  * @retval None
  */
static void MX_SPI1_Init(void)
{

  /* USER CODE BEGIN SPI1_Init 0 */

  /* USER CODE END SPI1_Init 0 */

  /* USER CODE BEGIN SPI1_Init 1 */

  /* USER CODE END SPI1_Init 1 */
  /* SPI1 parameter configuration*/
  hspi1.Instance = SPI1;
  hspi1.Init.Mode = SPI_MODE_MASTER;
  hspi1.Init.Direction = SPI_DIRECTION_2LINES;
  hspi1.Init.DataSize = SPI_DATASIZE_8BIT;
  hspi1.Init.CLKPolarity = SPI_POLARITY_LOW;
  hspi1.Init.CLKPhase = SPI_PHASE_1EDGE;
  hspi1.Init.NSS = SPI_NSS_SOFT;
  hspi1.Init.BaudRatePrescaler = SPI_BAUDRATEPRESCALER_4;
  hspi1.Init.FirstBit = SPI_FIRSTBIT_MSB;
  hspi1.Init.TIMode = SPI_TIMODE_DISABLE;
  hspi1.Init.CRCCalculation = SPI_CRCCALCULATION_DISABLE;
  hspi1.Init.CRCPolynomial = 10;
  if (HAL_SPI_Init(&hspi1) != HAL_OK)
  {
    Error_Handler();
  }
  /* USER CODE BEGIN SPI1_Init 2 */

  /* USER CODE END SPI1_Init 2 */

}

/**
  * @brief GPIO Initialization Function
  * @param None
  * @retval None
  */
static void MX_GPIO_Init(void)
{
  GPIO_InitTypeDef GPIO_InitStruct = {0};

  /* GPIO Ports Clock Enable */
  __HAL_RCC_GPIOE_CLK_ENABLE();
  __HAL_RCC_GPIOF_CLK_ENABLE();
  __HAL_RCC_GPIOA_CLK_ENABLE();

  /*Configure GPIO pin Output Level */
  HAL_GPIO_WritePin(GPIOE, CS_Pin|DC_Pin, GPIO_PIN_SET);

  /*Configure GPIO pin Output Level */
  HAL_GPIO_WritePin(RESET_GPIO_Port, RESET_Pin, GPIO_PIN_RESET);

  /*Configure GPIO pins : CS_Pin DC_Pin */
  GPIO_InitStruct.Pin = CS_Pin|DC_Pin;
  GPIO_InitStruct.Mode = GPIO_MODE_OUTPUT_PP;
  GPIO_InitStruct.Pull = GPIO_NOPULL;
  GPIO_InitStruct.Speed = GPIO_SPEED_FREQ_LOW;
  HAL_GPIO_Init(GPIOE, &GPIO_InitStruct);

  /*Configure GPIO pin : RESET_Pin */
  GPIO_InitStruct.Pin = RESET_Pin;
  GPIO_InitStruct.Mode = GPIO_MODE_OUTPUT_PP;
  GPIO_InitStruct.Pull = GPIO_NOPULL;
  GPIO_InitStruct.Speed = GPIO_SPEED_FREQ_LOW;
  HAL_GPIO_Init(RESET_GPIO_Port, &GPIO_InitStruct);

}

/* USER CODE BEGIN 4 */

/* USER CODE END 4 */

/**
  * @brief  This function is executed in case of error occurrence.
  * @retval None
  */
void Error_Handler(void)
{
  /* USER CODE BEGIN Error_Handler_Debug */
  /* User can add his own implementation to report the HAL error return state */
  __disable_irq();
  while (1)
  {
  }
  /* USER CODE END Error_Handler_Debug */
}

#ifdef  USE_FULL_ASSERT
/**
  * @brief  Reports the name of the source file and the source line number
  *         where the assert_param error has occurred.
  * @param  file: pointer to the source file name
  * @param  line: assert_param error line source number
  * @retval None
  */
void assert_failed(uint8_t *file, uint32_t line)
{
  /* USER CODE BEGIN 6 */
  /* User can add his own implementation to report the file name and line number,
     ex: printf("Wrong parameters value: file %s on line %d\r\n", file, line) */
  /* USER CODE END 6 */
}
#endif /* USE_FULL_ASSERT */

/************************ (C) COPYRIGHT STMicroelectronics *****END OF FILE****/
