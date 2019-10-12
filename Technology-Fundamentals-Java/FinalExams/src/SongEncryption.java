import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!"end".equals(line)) {
            String[] tokens = line.split(":");
            String artist = tokens[0];
            String song = tokens[1];
            boolean isValidArtist = false;
            isValidArtist = validateArtist(artist);
            boolean isValidSong = false;
            isValidSong = validateSong(song);
            int key = artist.length();
            if (isValidArtist && isValidSong) {
                String encryptedSong = "";
                encryptedSong = encryptSong(song, key, encryptedSong, artist);
                String encryptedArtist = "";
                encryptedArtist = encryptArtist(artist, key, encryptedArtist);
                System.out.printf("Successful encryption: %s@%s%n", encryptedArtist, encryptedSong);
            } else {
                System.out.println("Invalid input!");
            }

            line = scanner.nextLine();
        }
    }
    private static String encryptArtist(String artist, int key, String encryptedArtist) {
        for (int i = 0; i < artist.length(); i++) {
            char letter = artist.charAt(i);
            key = artist.length();

            if (letter != ' ' && letter != '\'') {
                int newLetterCode = (int) artist.charAt(i) + key;
                int letterCode = (int) artist.charAt(i);
                if (letterCode + key > 122) {
                    key = key - (122 - letterCode);
                    newLetterCode = 96 + key;
                    char letterToAdd = (char) newLetterCode;
                    encryptedArtist += letterToAdd;
                } else {
                    char newLetter = (char) newLetterCode;
                    encryptedArtist += newLetter;
                }
            } else {
                encryptedArtist += letter;
            }
        }

        return encryptedArtist;
    }

    private static String encryptSong(String song, int key, String encryptedSong, String artist) {
        for (int i = 0; i < song.length(); i++) {
            char letter = song.charAt(i);
            key = artist.length();
            if (letter != ' ' && letter != '\'') {
                int newLetterCode = (int) song.charAt(i) + key;
                int letterCode = (int) song.charAt(i);
                if (letterCode + key > 90) {
                    key = key - (90 - letterCode);
                    newLetterCode = 64 + key;
                    char letterToAdd = (char) newLetterCode;
                    encryptedSong += letterToAdd;
                } else {
                    char newLetter = (char) newLetterCode;
                    encryptedSong += newLetter;
                }
            } else {
                encryptedSong += letter;
            }
        }

        return encryptedSong;
    }


    private static boolean validateSong(String song) {
        boolean isValid = false;
        String regex = "^[A-Z ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(song);
        if (matcher.find()) {
            isValid = true;
        }
        return isValid;

    }
    private static boolean validateArtist(String artist) {
        boolean isValid = false;
        String regex = "^[A-Z][a-z ']+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(artist);
        if (matcher.find()) {
            isValid = true;
        }
        return isValid;
    }
}
