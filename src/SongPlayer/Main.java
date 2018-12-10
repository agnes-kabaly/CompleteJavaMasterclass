package SongPlayer;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Year Zero", "Nine Inch Nails");
        album.addSong("Hyperpower!", 1.42);
        album.addSong("The Beginning of the End", 2.47);
        album.addSong("Survivalism", 4.23);
        album.addSong("The Good Soldier", 3.23);
        album.addSong("Vessel", 4.52);
        album.addSong("Capital G", 3.50);
        album.addSong("My Violent Heart", 4.13);
        album.addSong("The Warning", 3.38);
        album.addSong("God Given", 3.50);
        album.addSong("Meet Your Master", 4.08);

        albums.add(album);

        Album album2 = new Album("The Golden Age of Grotesque", "Marilyn MAnson");
        album2.addSong("Thaeter", 1.14);
        album2.addSong(	"This Is the New Shit", 4.20);
        album2.addSong("mOBSCENE", 3.25);
        album2.addSong("Doll-Dagga Buzz-Buzz Ziggety-Zag", 4.11);
        album2.addSong("Use Your Fist and Not Your Mouth", 3.34);
        album2.addSong("The Golden Age of Grotesque", 4.05);
        album2.addSong("(s)AINT", 3.42);
        album2.addSong("Ka-Boom Ka-Boom", 4.02);

        albums.add(album2);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Capital G", playList);
        albums.get(0).addToPlayList("God Given", playList);
        albums.get(0).addToPlayList("Copy of A", playList); // Does not exist in this album
        albums.get(0).addToPlayList(10, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(6, playList);
        albums.get(1).addToPlayList(7, playList);
        albums.get(1).addToPlayList(22, playList); // There is no track 22

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("we are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit");
        System.out.println("1 - to play next song");
        System.out.println("2 - to play previous song");
        System.out.println("3 - to replay the current song");
        System.out.println("4 - list songs in the playlist");
        System.out.println("5 - print available actions");
        System.out.println("6 - delete current song from playlist.");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("===================================");
    }

}
