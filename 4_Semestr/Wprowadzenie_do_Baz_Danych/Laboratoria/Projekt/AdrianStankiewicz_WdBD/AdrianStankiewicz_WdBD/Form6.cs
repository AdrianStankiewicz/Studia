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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void leaderBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.leaderBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.database1DataSet1);

        }

        private void Form6_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'database1DataSet1.Leader' table. You can move, or remove it, as needed.
            this.leaderTableAdapter.Fill(this.database1DataSet1.Leader);

        }
    }
}
