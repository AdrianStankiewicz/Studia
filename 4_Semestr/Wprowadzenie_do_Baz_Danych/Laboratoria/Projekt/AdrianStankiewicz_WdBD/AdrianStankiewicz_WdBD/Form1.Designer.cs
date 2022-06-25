
namespace AdrianStankiewicz_WdBD
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.button7 = new System.Windows.Forms.Button();
            this.fillToolStrip = new System.Windows.Forms.ToolStrip();
            this.paramIdGroupToolStripLabel = new System.Windows.Forms.ToolStripLabel();
            this.paramIdGroupToolStripTextBox = new System.Windows.Forms.ToolStripTextBox();
            this.fillToolStripButton = new System.Windows.Forms.ToolStripButton();
            this.functionIdGroupCountDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.functionIdGroupCountBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.database1DataSet1 = new AdrianStankiewicz_WdBD.Database1DataSet1();
            this.functionIdGroupCountTableAdapter = new AdrianStankiewicz_WdBD.Database1DataSet1TableAdapters.FunctionIdGroupCountTableAdapter();
            this.tableAdapterManager = new AdrianStankiewicz_WdBD.Database1DataSet1TableAdapters.TableAdapterManager();
            this.functionClassesInDayBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.functionClassesInDayTableAdapter = new AdrianStankiewicz_WdBD.Database1DataSet1TableAdapters.FunctionClassesInDayTableAdapter();
            this.fillToolStrip1 = new System.Windows.Forms.ToolStrip();
            this.paramDayToolStripLabel = new System.Windows.Forms.ToolStripLabel();
            this.paramDayToolStripTextBox = new System.Windows.Forms.ToolStripTextBox();
            this.fillToolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.functionClassesInDayDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox1.SuspendLayout();
            this.fillToolStrip.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.functionIdGroupCountDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.functionIdGroupCountBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.database1DataSet1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.functionClassesInDayBindingSource)).BeginInit();
            this.fillToolStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.functionClassesInDayDataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Location = new System.Drawing.Point(6, 19);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(149, 54);
            this.button1.TabIndex = 0;
            this.button1.Text = "User";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button2.Location = new System.Drawing.Point(6, 79);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(149, 54);
            this.button2.TabIndex = 1;
            this.button2.Text = "Regs";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button3.Location = new System.Drawing.Point(6, 139);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(149, 54);
            this.button3.TabIndex = 2;
            this.button3.Text = "Group";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button4
            // 
            this.button4.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button4.Location = new System.Drawing.Point(6, 199);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(149, 54);
            this.button4.TabIndex = 3;
            this.button4.Text = "Class";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // button5
            // 
            this.button5.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button5.Location = new System.Drawing.Point(6, 259);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(149, 54);
            this.button5.TabIndex = 4;
            this.button5.Text = "Leader";
            this.button5.UseVisualStyleBackColor = true;
            this.button5.Click += new System.EventHandler(this.button5_Click);
            // 
            // button6
            // 
            this.button6.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button6.Location = new System.Drawing.Point(6, 317);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(149, 54);
            this.button6.TabIndex = 5;
            this.button6.Text = "Abilities";
            this.button6.UseVisualStyleBackColor = true;
            this.button6.Click += new System.EventHandler(this.button6_Click);
            // 
            // label1
            // 
            this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(298, 50);
            this.label1.TabIndex = 6;
            this.label1.Text = "Aplikacja\r\n\"Młodzieżowy Dom Kultury\"";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox1.Controls.Add(this.button7);
            this.groupBox1.Controls.Add(this.button1);
            this.groupBox1.Controls.Add(this.button4);
            this.groupBox1.Controls.Add(this.button6);
            this.groupBox1.Controls.Add(this.button5);
            this.groupBox1.Controls.Add(this.button3);
            this.groupBox1.Controls.Add(this.button2);
            this.groupBox1.Location = new System.Drawing.Point(316, 14);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(168, 458);
            this.groupBox1.TabIndex = 7;
            this.groupBox1.TabStop = false;
            // 
            // button7
            // 
            this.button7.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button7.Location = new System.Drawing.Point(6, 377);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(149, 54);
            this.button7.TabIndex = 6;
            this.button7.Text = "Skills";
            this.button7.UseVisualStyleBackColor = true;
            this.button7.Click += new System.EventHandler(this.button7_Click);
            // 
            // fillToolStrip
            // 
            this.fillToolStrip.Dock = System.Windows.Forms.DockStyle.None;
            this.fillToolStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.paramIdGroupToolStripLabel,
            this.paramIdGroupToolStripTextBox,
            this.fillToolStripButton});
            this.fillToolStrip.Location = new System.Drawing.Point(26, 91);
            this.fillToolStrip.Name = "fillToolStrip";
            this.fillToolStrip.Size = new System.Drawing.Size(263, 25);
            this.fillToolStrip.TabIndex = 9;
            this.fillToolStrip.Text = "fillToolStrip";
            // 
            // paramIdGroupToolStripLabel
            // 
            this.paramIdGroupToolStripLabel.Name = "paramIdGroupToolStripLabel";
            this.paramIdGroupToolStripLabel.Size = new System.Drawing.Size(89, 22);
            this.paramIdGroupToolStripLabel.Text = "Podaj ID Grupy:";
            // 
            // paramIdGroupToolStripTextBox
            // 
            this.paramIdGroupToolStripTextBox.Name = "paramIdGroupToolStripTextBox";
            this.paramIdGroupToolStripTextBox.Size = new System.Drawing.Size(100, 25);
            // 
            // fillToolStripButton
            // 
            this.fillToolStripButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.fillToolStripButton.Name = "fillToolStripButton";
            this.fillToolStripButton.Size = new System.Drawing.Size(60, 22);
            this.fillToolStripButton.Text = "Wyszukaj";
            this.fillToolStripButton.Click += new System.EventHandler(this.fillToolStripButton_Click);
            // 
            // functionIdGroupCountDataGridView
            // 
            this.functionIdGroupCountDataGridView.AllowUserToAddRows = false;
            this.functionIdGroupCountDataGridView.AllowUserToDeleteRows = false;
            this.functionIdGroupCountDataGridView.AutoGenerateColumns = false;
            this.functionIdGroupCountDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.functionIdGroupCountDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1});
            this.functionIdGroupCountDataGridView.DataSource = this.functionIdGroupCountBindingSource;
            this.functionIdGroupCountDataGridView.Location = new System.Drawing.Point(26, 119);
            this.functionIdGroupCountDataGridView.Name = "functionIdGroupCountDataGridView";
            this.functionIdGroupCountDataGridView.ReadOnly = true;
            this.functionIdGroupCountDataGridView.Size = new System.Drawing.Size(263, 48);
            this.functionIdGroupCountDataGridView.TabIndex = 9;
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.dataGridViewTextBoxColumn1.DataPropertyName = "IloscUczestników";
            this.dataGridViewTextBoxColumn1.HeaderText = "IloscUczestników";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            this.dataGridViewTextBoxColumn1.ReadOnly = true;
            // 
            // functionIdGroupCountBindingSource
            // 
            this.functionIdGroupCountBindingSource.DataMember = "FunctionIdGroupCount";
            this.functionIdGroupCountBindingSource.DataSource = this.database1DataSet1;
            // 
            // database1DataSet1
            // 
            this.database1DataSet1.DataSetName = "Database1DataSet1";
            this.database1DataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // functionIdGroupCountTableAdapter
            // 
            this.functionIdGroupCountTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AbilitiesTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.ClassTableAdapter = null;
            this.tableAdapterManager.Connection = null;
            this.tableAdapterManager.GroupTableAdapter = null;
            this.tableAdapterManager.LeaderTableAdapter = null;
            this.tableAdapterManager.RegsTableAdapter = null;
            this.tableAdapterManager.SkillsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = AdrianStankiewicz_WdBD.Database1DataSet1TableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.UserTableAdapter = null;
            // 
            // functionClassesInDayBindingSource
            // 
            this.functionClassesInDayBindingSource.DataMember = "FunctionClassesInDay";
            this.functionClassesInDayBindingSource.DataSource = this.database1DataSet1;
            // 
            // functionClassesInDayTableAdapter
            // 
            this.functionClassesInDayTableAdapter.ClearBeforeFill = true;
            // 
            // fillToolStrip1
            // 
            this.fillToolStrip1.Dock = System.Windows.Forms.DockStyle.None;
            this.fillToolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.paramDayToolStripLabel,
            this.paramDayToolStripTextBox,
            this.fillToolStripButton1});
            this.fillToolStrip1.Location = new System.Drawing.Point(26, 185);
            this.fillToolStrip1.Name = "fillToolStrip1";
            this.fillToolStrip1.Size = new System.Drawing.Size(258, 25);
            this.fillToolStrip1.TabIndex = 10;
            this.fillToolStrip1.Text = "fillToolStrip1";
            // 
            // paramDayToolStripLabel
            // 
            this.paramDayToolStripLabel.Name = "paramDayToolStripLabel";
            this.paramDayToolStripLabel.Size = new System.Drawing.Size(104, 22);
            this.paramDayToolStripLabel.Text = "Podaj numer dnia:";
            // 
            // paramDayToolStripTextBox
            // 
            this.paramDayToolStripTextBox.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.paramDayToolStripTextBox.Name = "paramDayToolStripTextBox";
            this.paramDayToolStripTextBox.Size = new System.Drawing.Size(80, 25);
            // 
            // fillToolStripButton1
            // 
            this.fillToolStripButton1.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.fillToolStripButton1.Name = "fillToolStripButton1";
            this.fillToolStripButton1.Size = new System.Drawing.Size(60, 22);
            this.fillToolStripButton1.Text = "Wyszukaj";
            this.fillToolStripButton1.Click += new System.EventHandler(this.fillToolStripButton1_Click);
            // 
            // functionClassesInDayDataGridView
            // 
            this.functionClassesInDayDataGridView.AllowUserToAddRows = false;
            this.functionClassesInDayDataGridView.AllowUserToDeleteRows = false;
            this.functionClassesInDayDataGridView.AutoGenerateColumns = false;
            this.functionClassesInDayDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.functionClassesInDayDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn2});
            this.functionClassesInDayDataGridView.DataSource = this.functionClassesInDayBindingSource;
            this.functionClassesInDayDataGridView.Location = new System.Drawing.Point(26, 213);
            this.functionClassesInDayDataGridView.Name = "functionClassesInDayDataGridView";
            this.functionClassesInDayDataGridView.ReadOnly = true;
            this.functionClassesInDayDataGridView.Size = new System.Drawing.Size(263, 114);
            this.functionClassesInDayDataGridView.TabIndex = 10;
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.dataGridViewTextBoxColumn2.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn2.HeaderText = "name";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(496, 484);
            this.Controls.Add(this.functionClassesInDayDataGridView);
            this.Controls.Add(this.fillToolStrip1);
            this.Controls.Add(this.functionIdGroupCountDataGridView);
            this.Controls.Add(this.fillToolStrip);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.fillToolStrip.ResumeLayout(false);
            this.fillToolStrip.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.functionIdGroupCountDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.functionIdGroupCountBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.database1DataSet1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.functionClassesInDayBindingSource)).EndInit();
            this.fillToolStrip1.ResumeLayout(false);
            this.fillToolStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.functionClassesInDayDataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button button7;
        private Database1DataSet1 database1DataSet1;
        private System.Windows.Forms.BindingSource functionIdGroupCountBindingSource;
        private Database1DataSet1TableAdapters.FunctionIdGroupCountTableAdapter functionIdGroupCountTableAdapter;
        private Database1DataSet1TableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.ToolStrip fillToolStrip;
        private System.Windows.Forms.ToolStripLabel paramIdGroupToolStripLabel;
        private System.Windows.Forms.ToolStripTextBox paramIdGroupToolStripTextBox;
        private System.Windows.Forms.ToolStripButton fillToolStripButton;
        private System.Windows.Forms.DataGridView functionIdGroupCountDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.BindingSource functionClassesInDayBindingSource;
        private Database1DataSet1TableAdapters.FunctionClassesInDayTableAdapter functionClassesInDayTableAdapter;
        private System.Windows.Forms.ToolStrip fillToolStrip1;
        private System.Windows.Forms.ToolStripLabel paramDayToolStripLabel;
        private System.Windows.Forms.ToolStripTextBox paramDayToolStripTextBox;
        private System.Windows.Forms.ToolStripButton fillToolStripButton1;
        private System.Windows.Forms.DataGridView functionClassesInDayDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
    }
}