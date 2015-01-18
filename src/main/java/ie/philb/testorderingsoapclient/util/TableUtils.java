/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.util;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author philb
 */
public class TableUtils {

    public static void resizeColumns(JTable table, int... widths) {

        for (int i = 0; i < table.getColumnCount(); i++) {

            if (i == widths.length) {
                break;
            }

            if (widths[i] == -1) {
                continue;
            }

            TableColumn column = table.getColumnModel().getColumn(i);
            column.setWidth(widths[i]);
            column.setPreferredWidth(widths[i]);
        }
    }
}
