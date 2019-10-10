import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song {
        String typeList;
        String name;
        String time;

        String getTypeList() {
            return this.typeList;
        }

        void setTypelist(String typeList) {
            this.typeList = typeList;
        }

        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        String getTime() {
            return this.time;
        }

        void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] songInput = input.split("_");
            String typeList = songInput[0];
            String name = songInput[1];
            String time = songInput[2];

            Song song = new Song();
            song.setTypelist(typeList);
            song.setName(name);
            song.setTime(time);

            songs.add(song);

        }
        String type = scanner.nextLine();
        if ("all".equals(type)) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }

        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(type)) {
                    System.out.println(song.getName());
                }
            }

        }


    }
}
