package dias.matheus;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class SpeedUpTest {
        public static void main(String[] args) {
            int[] threads = {1,2, 4, 6, 8};
            double[] tempos = {10000, 5000, 3000, 2000, 2000};

            double tempoSerial = tempos[0];
            double[] speedUp = new double[tempos.length];

            for(int i = 0; i < tempos.length; i++)
            {
                speedUp[i] = tempoSerial / tempos[i];
            }

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for(int i = 0; i < threads.length; i++)
            {
                dataset.addValue(speedUp[i], "speed-up", threads[i] + "Threads");
            }

            JFreeChart lineChart = ChartFactory.createLineChart(
                    "Speed-Up",       // Título
                    "Número de Threads",         // Eixo X
                    "Speed-Up",                  // Eixo Y
                    dataset                      // Dados
            );
            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(chartPanel);
            frame.pack();
            frame.setVisible(true);

        }


}
