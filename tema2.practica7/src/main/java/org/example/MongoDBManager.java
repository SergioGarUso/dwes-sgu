package org.example;


import org.example.entitites.Profile;

public class MongoDBManager {

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
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void publishPost(String title, String content) {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void updateStatus(String status) {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void deleteProfile() {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void showProfiles() {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void showPosts(String profileName) {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void likePost(String profileName, String title) {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void commentPost(String profileName, String title, String comment) {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void showProfileStats() {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }

    public void showAllStats() {
        throw new UnsupportedOperationException("Funcionalidad no implementada");
    }
}
