package sistema.application;

import sistema.entities.Musica;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    static void main() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Título da música: ");

            String titulo = sc.nextLine();
            System.out.print("Artista: ");
            String artista = sc.nextLine();
            System.out.print("Ano do Lançamento: ");
            int anoLancamento = sc.nextInt();
            Musica musica = new Musica(titulo, artista, anoLancamento);

            String path = "C:\\playlist\\minha_playlist.txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                bw.write(musica.toString());
                bw.newLine();
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }


        } catch (
                InputMismatchException exception) {
            System.out.println("Error: Foram inseridas letras no lugar de números ");
        }
    }
}
