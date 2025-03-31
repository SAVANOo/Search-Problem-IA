package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import main.algorithm.BFS;
import main.algorithm.DFS;
import main.algorithm.IDDFS;
import main.algorithm.Bidirectional;
import main.entity.Node;
import main.src.Algorithm;
import main.src.ResultAdapter;
import main.entity.Three;

public class SearchUI {
    private JFrame window;
    private JComboBox<String> initialNodeBox;
    private JComboBox<String> targetNodeBox;
    private JTextField limitField;
    private JLabel limitLabel;
    private JComboBox<Algorithm> algorithmBox;
    private JTextArea resultArea;
    private JLabel mapLabel;
    private ImageIcon mapIcon;
    private BufferedImage mapImage;
    private final Three three = Three.getInstance();

    public SearchUI() {
        window = new JFrame("Problemas de Busca");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridBagLayout());

        window.setSize(1200, 800);
        window.setResizable(true);

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Ponto inicial:"));
        initialNodeBox = new JComboBox<>(three.getNodeNameList());
        inputPanel.add(initialNodeBox);

        inputPanel.add(new JLabel("Ponto final:"));
        targetNodeBox = new JComboBox<>(three.getNodeNameList());
        inputPanel.add(targetNodeBox);

        inputPanel.add(new JLabel("Escolha o algoritmo de busca:"));
        algorithmBox = new JComboBox<>(Algorithm.values());
        inputPanel.add(algorithmBox);

        limitLabel = new JLabel("Se desejar informe um limite:");
        limitField = new JTextField();
        limitLabel.setVisible(false);
        limitField.setVisible(false);

        inputPanel.add(limitLabel);
        inputPanel.add(limitField);

        JButton searchButton = new JButton("Buscar caminho");
        searchButton.addActionListener(new SearchAction());
        inputPanel.add(searchButton);

        algorithmBox.addActionListener(e -> {
            Algorithm selected = (Algorithm) algorithmBox.getSelectedItem();
            boolean showLimit = selected != null && selected.supportsLimit();
            limitLabel.setVisible(showLimit);
            limitField.setVisible(showLimit);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(inputPanel, gbc);


        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setPreferredSize(new Dimension(750, 120));
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(resultScrollPane, gbc);

        try {
            mapImage = ImageIO.read(new File("assets/map.png"));
            mapIcon = new ImageIcon(mapImage);
            mapLabel = new JLabel(mapIcon);
        } catch (IOException e) {
            System.err.println("Problemas ao carregar imagem, cheque o caminho.");
        }

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        window.add(mapLabel, gbc);

        window.setVisible(true);
    }

    private class SearchAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String initialName = (String) initialNodeBox.getSelectedItem();
            String targetName = (String) targetNodeBox.getSelectedItem();
            Algorithm algorithm = (Algorithm) algorithmBox.getSelectedItem();
            if (initialName == null || targetName == null || algorithm == null) return;

            Node initial = three.getNodeFromName(initialName);
            Node target = three.getNodeFromName(targetName);
            Integer limit = buildLimit(algorithm);


            ResultAdapter result = algorithmHandler(algorithm, initial, target, limit);
            showResult(result);
        }
    }

    private Integer buildLimit(Algorithm algorithm) {
        if (!algorithm.supportsLimit()) return null;
        Integer limit = null;

        try {
            String inputLimit = limitField.getText();
            if (inputLimit.isEmpty()) return -1;

            limit = Integer.parseInt(inputLimit);
            if (limit < 0) throw new NumberFormatException("Limite negativo");
        } catch (NumberFormatException ex) {
            resultArea.setText("Limite inválido, por favor insira um número válido. (Positivo ou Zero).");
        }

        return limit;
    }

    private static ResultAdapter algorithmHandler(Algorithm algorithm, Node initial, Node target, Integer limit) {
        return switch (algorithm) {
            case BFS -> BFS.search(initial, target);
            case DFS -> DFS.searchWithDeepLimit(initial, target, limit);
            case IDDFS -> IDDFS.searchWithDeepLimit(initial, target, limit);
            case BIDIRECTIONAL -> Bidirectional.search(initial, target);
        };
    }

    private void showResult(ResultAdapter result) {
        if (result == null || result.getPath().isEmpty()) {
            resultArea.setText("Nenhum caminho encontrado.");
        } else {
            resultArea.setText(result.buildFormattedResultPath());
        }
    }
}
