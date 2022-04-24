import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class json {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/data.json")) {
            Map<String, List<Double>> map = gson.fromJson(reader, Map.class);
            int max_size = 0;
            for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
                if (entry.getValue().size() > max_size) {
                    max_size = entry.getValue().size();
                }
            }
            String[][] table = new String[max_size + 1][map.size()];
            int i = 0;
            for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
                int j = 1;
                table[0][i] = entry.getKey();
                for (int v = 0; v < entry.getValue().size(); v++) {
                    table[j][i] = entry.getValue().get(v).toString();
                    j++;
                }
                i++;
            }
            String[] columns = new String[map.size()];
            for (i = 0; i < map.size(); i++) {
                columns[i] = table[0][i];
            }
            String[][] rows = new String[max_size][map.size()];
            System.arraycopy(table, 1, rows, 0, max_size);

            JFrame f = new JFrame("JTable Sample");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container content = f.getContentPane();
            JTable table_print = new JTable(rows, columns);
            JScrollPane scrollPane = new JScrollPane(table_print);
            content.add(scrollPane, BorderLayout.CENTER);
            f.setSize(300, 200);
            f.setVisible(true);

        } catch (IOException e) {
            System.err.println("Error! Problems with file. Try again!");
        }

    }


}
