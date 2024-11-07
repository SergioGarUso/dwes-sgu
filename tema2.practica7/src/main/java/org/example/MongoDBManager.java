package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.example.entitites.Post;
import org.example.entitites.Profile;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBManager {

    private static Scanner scanner = new Scanner(System.in);
    MongoCollection<Profile> profiles; // Colección de perfiles
    Profile myProfile; // Mi perfil

    public MongoDBManager(String uri, String databaseName, String collectionName) {
        MongoClient mongoClient;
        try {
            mongoClient = MongoClients.create(uri);
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);

            profiles = database.getCollection(collectionName, Profile.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void createProfile(String name, String status, int age) {
        myProfile = new Profile(name, status, age);
        profiles.insertOne(myProfile);

    }

    public void publishPost(String title, String content) {
        Post post = new Post(title, content);
        List<Post> posts= myProfile.getPosts();
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
        profiles.replaceOne(eq(myProfile.getId()), new Profile(myProfile.getName(), myProfile.getStatus(), myProfile.getAge(), posts));
    }

    public void updateStatus(String status) {
        myProfile.setStatus(status);
        profiles.replaceOne(eq(myProfile.getId()), myProfile);
    }

    public void deleteProfile() {
        profiles.deleteOne(eq(myProfile.getId()));
    }

    public void showProfiles() {
        for (Profile profile : profiles.find()) {
            System.out.println(profile);
        }
    }

    public void showPosts(String profileName) {
        Profile perfilSearch = null;
        for (Profile profile : profiles.find(eq("name", profileName))) {
            perfilSearch = profile;
        }

        if (perfilSearch!=null) {
            System.out.println(perfilSearch);
        }else {
            System.out.println("Perfil no encontrado");
        }
    }

    public void likePost(String profileName, String title) {
        Profile perfilSearch = null;
        for (Profile profile : profiles.find(eq("name", profileName))) {
            perfilSearch = profile;
        }

        if (perfilSearch!=null) {
            Post postSearch = null;
            for (Post post : perfilSearch.getPosts()) {
                if (post.getTitle().equals(title)) {
                    postSearch = post;
                }
            }
            if (postSearch!=null) {
                postSearch.setLikes(postSearch.getLikes() + 1);
                profiles.replaceOne(eq(perfilSearch.getId()), perfilSearch);
            }else{
                System.out.println("Publicación no encontrada");
            }
        }else {
            System.out.println("Perfil no encontrado");
        }
    }

    public void commentPost(String profileName, String title, String comment) {
        Profile perfilSearch = null;
        for (Profile profile : profiles.find(eq("name", profileName))) {
            perfilSearch = profile;
        }

        if (perfilSearch!=null) {
            Post postSearch = null;
            for (Post post : perfilSearch.getPosts()) {
                if (post.getTitle().equals(title)) {
                    postSearch = post;
                }
            }
            if (postSearch!=null) {
                postSearch.getComments().add(comment);
                profiles.replaceOne(eq(perfilSearch.getId()), perfilSearch);
            }else{
                System.out.println("Publicación no encontrada");
            }
        }else {
            System.out.println("Perfil no encontrado");
        }
    }

    public void showProfileStats() {
        System.out.println("Dime cual es tu perfil:");
        String name = scanner.nextLine();
        Profile profile = profiles.find(eq("name", name)).first();
        if (profile != null) {
            int numLikes = 0;
            int numComments = 0;
            for (Post post : profile.getPosts()) {
                numLikes += post.getLikes();
                numComments += post.getComments().size();
            }
            System.out.println("Numero publicaciones: " + profile.getPosts().size());

            System.out.println("Numero likes: " + numLikes);
            System.out.println("Numero comentarios: " + numComments);
        } else {
            System.out.println("Perfil no encontrado");
        }
    }

    public void showAllStats() {
        int numLikes = 0;
        int numComments = 0;
        for (Profile profile : profiles.find()) {
            for (Post post : profile.getPosts()) {
                numLikes += post.getLikes();
                numComments += post.getComments().size();
            }
            System.out.println("Numero publicaciones: " + profile.getPosts().size());

            System.out.println("Numero likes: " + numLikes);
            System.out.println("Numero comentarios: " + numComments);
        }
    }
}
