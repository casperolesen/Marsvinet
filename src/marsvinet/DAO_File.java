package marsvinet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_File {

    private String filename = "members_delfinen.txt";
    private Path filepath = Paths.get("members_delfinen.txt");
    private List<Member_File> members = null;

    public List<Member_File> getMembers() {
        members = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line.split(",")[0].trim());
                String name = line.split(",")[1].trim();
                String email = line.split(",")[2].trim();
                LocalDate birthday = LocalDate.parse(line.split(",")[3].trim());
                Boolean active = Boolean.valueOf(line.split(",")[4].trim());
                Boolean elite = Boolean.valueOf(line.split(",")[5].trim());

                Member_File member = new Member_File(id, name, email, birthday, active, elite);
                members.add(member);

            }

            return members;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO_File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_File.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public Member_File getMember(int member_ID) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(Integer.toString(member_ID))) {
                    int id = Integer.parseInt(line.split(",")[0].trim());
                    String name = line.split(",")[1].trim();
                    String email = line.split(",")[2].trim();
                    LocalDate birthday = LocalDate.parse(line.split(",")[3].trim());
                    Boolean active = Boolean.valueOf(line.split(",")[4].trim());
                    Boolean elite = Boolean.valueOf(line.split(",")[5].trim());

                    Member_File member = new Member_File(id, name, email, birthday, active, elite);
                    
                    return member;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO_File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_File.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void editMember() {
        String oldLine = "3 Casper Kruse Olesen 1990-03-27 true true";
        String newLine = "Teksten ændret ved appstart. Se DAO_File";
        try {
            List<String> allLines = new ArrayList<>(Files.readAllLines(filepath));

            for (int i = 0; i < allLines.size(); i++) {
                if (allLines.get(i).equals(oldLine)) {
                    allLines.set(i, newLine);
                    break;
                }
            }
            Files.write(filepath, allLines);
        } catch (IOException ex) {
            Logger.getLogger(DAO_File.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void deleteMember() {
    }
}
