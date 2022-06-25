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
    public partial class Form8 : Form
    {
        public Form8()
        {
            InitializeComponent();
        }

        private void skillsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.skillsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.database1DataSet1);

        }

        private void Form8_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'database1DataSet1.Skills' table. You can move, or remove it, as needed.
            this.skillsTableAdapter.Fill(this.database1DataSet1.Skills);

        }
    }
}
