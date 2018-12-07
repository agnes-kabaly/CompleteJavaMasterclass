package SongPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

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

    }

}
