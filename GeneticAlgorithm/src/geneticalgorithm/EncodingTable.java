/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package geneticalgorithm;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EncodingTable extends JPanel {
    private boolean DEBUG = false;


    public EncodingTable(String Solution[],String BinaryEncoding[],int FitnessValue[],int range) {
        super(new GridLayout(1,0));

        String[] columnNames = {"Solution ",
                                "Binray Encoding",
                                "Fitness Value",
                                };

        Object data[][] =new Object[range+1][3];

        for(int i=0;i<range;i++)

            {

                data[i][0]="( "+Solution[i].split("-")[0] +" , "+Solution[i].split("-")[1]+ " )";
                data[i][1]=BinaryEncoding[i];
                data[i][2]=FitnessValue[i];
            }



        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1500, 70));
        table.setFillsViewportHeight(false);


        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
}

