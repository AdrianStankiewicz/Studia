using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AdrianStankiewicz_WdBD
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form f2 = new Form2();
            f2.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form f3 = new Form3();
            f3.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form f4 = new Form4();
            f4.ShowDialog();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Form f5 = new Form5();
            f5.ShowDialog();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Form f6 = new Form6();
            f6.ShowDialog();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            Form f7 = new Form7();
            f7.ShowDialog();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            Form f8 = new Form8();
            f8.ShowDialog();
        }

        private void fillToolStripButton_Click(object sender, EventArgs e)
        {
            try
            {
                this.functionIdGroupCountTableAdapter.Fill(this.database1DataSet1.FunctionIdGroupCount, ((int)(System.Convert.ChangeType(paramIdGroupToolStripTextBox.Text, typeof(int)))));
            }
            catch (System.Exception ex)
            {
                System.Windows.Forms.MessageBox.Show(ex.Message);
            }

        }

        private void fillToolStripButton1_Click(object sender, EventArgs e)
        {
            try
            {
                this.functionClassesInDayTableAdapter.Fill(this.database1DataSet1.FunctionClassesInDay, ((int)(System.Convert.ChangeType(paramDayToolStripTextBox.Text, typeof(int)))));
            }
            catch (System.Exception ex)
            {
                System.Windows.Forms.MessageBox.Show(ex.Message);
            }

        }
    }
}
