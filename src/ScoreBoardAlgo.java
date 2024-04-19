
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreBoardAlgo {
    public String[] lines = new String[5];
    public String[] saved_player_names = new String[5];
    public int[] saved_scores = new int[5];
    public int score = CarGame.score;
    public int new_player_que_index = 0;
    public File inputFile;
    public File tempFile;

    public void Read_and_Process() {
        int i = 0;
        String sourcepath_original = "./lib/scores.txt";
        try {
            inputFile = new File(sourcepath_original);
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine;
            while (i < 5) {    // Read lines from the file until the end is reached.
                readLine = bufferedReader.readLine();
                lines[i] = readLine;
                i++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    
        
        for (int a = 0; a < 5; a++) { // Separate player names with scores
            String readed_line = lines[a];
            if (readed_line != null) {
                int index = readed_line.indexOf(",");
                saved_player_names[a] = readed_line.substring(0, index - 1);
                saved_scores[a] = Integer.parseInt(readed_line.substring(index + 2, readed_line.length()));
            }
        }
    }
    
        public int Comapre_Scores(){ // if int new_player_que_index > 0 draw New_Hs GUI
            for(int a = 0; a < 5 ; a++){
                if(saved_scores[a] < this.score){new_player_que_index = a; return new_player_que_index;}
            }
            return 0;
        }

        public void Insert_New_HS(String new_name){
            String lines_temp[] = new String[4-new_player_que_index];
            int a = 0;
            for(int i = new_player_que_index; i + 1 < 5 ; i++){
                lines_temp[a] = lines[i];
                a++;
            }
            saved_player_names[new_player_que_index] = new_name;
            saved_scores[new_player_que_index] = this.score;
            String new_line = new_name + " , " + saved_scores[new_player_que_index];
            lines[new_player_que_index] = new_line;
            // fix here --------------------------------------------
            a = new_player_que_index;
            int b = 0;
            while(a+1 < 5){ 
                lines[a+1] = lines_temp[b];
                a++;
                b++;}

            try {
            tempFile = new File("temp.txt");
            FileWriter filewriter = new FileWriter(tempFile);
            BufferedWriter writer = new BufferedWriter(filewriter);

            for(int i = 0; i < 5; i++){
            writer.write(lines[i] + "\n");
            }
            writer.close();
             if (!inputFile.delete()) {
                System.out.println("Could not delete the original file.");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename the temporary file.");
            }

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
        }
}





























