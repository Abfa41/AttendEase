package com.example.attendease.Database;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.attendease.Model.Student;
import com.example.attendease.Model.Teacher;

import org.bson.Document;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class DB {
    private Realm realm;
    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;
    private App app;

    private final String appID = "application-0-bmmbvuh";
    private final String TAG = "Database Error";

    private Context context;

    public DB(Context context){
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();

        app = new App(new AppConfiguration.Builder(appID).build());
        Log.e("Hello world","Hello world");

        // Get the MongoClient and MongoDatabase
        app.loginAsync(io.realm.mongodb.Credentials.anonymous(), it -> {
            if (it.isSuccess()) {
                Log.v(TAG, "Successfully authenticated anonymously.");

                User user = app.currentUser();
                mongoClient = user.getMongoClient("mongodb-atlas");
                mongoDatabase = mongoClient.getDatabase("AttendEase");

            } else {
                Log.e(TAG, "Failed to authenticate anonymously: " + it.getError().toString());
            }
        });
    }

    public boolean ifStudentExists(Student s){
        AtomicInteger i = new AtomicInteger(0);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("Student");
        Document doc = new Document("pin",s.getPin())
                .append("name",s.getName())
                .append("phone",s.getPhone());
        mongoCollection.find(doc).iterator().getAsync(task -> {
            if(task.isSuccess()){
                if(task.get().hasNext()){
                    Toast.makeText(context, "Student Exists...", Toast.LENGTH_SHORT).show();
                    i.set(1);
                }
                else{
                    Toast.makeText(context, "Student Does not Exist", Toast.LENGTH_SHORT).show();
                    i.set(0);
                }

            }
            else{
                Toast.makeText(context, "Wrong Pin/Name/Phone...", Toast.LENGTH_SHORT).show();
                i.set(0);
            }
        });
        if(i.get()==1) return true;
        return false;
    }

    public boolean ifTeacherExists(Teacher t){
        AtomicInteger i = new AtomicInteger(0);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("Teacher");
        Document doc = new Document("pin",t.getTeacher_ID())
                .append("name",t.getName())
                .append("phone",t.getPhone());
        mongoCollection.find(doc).iterator().getAsync(task -> {
            if(task.isSuccess()){
                if(task.get().hasNext()){
                    Toast.makeText(context, "Teacher Exists...", Toast.LENGTH_SHORT).show();
                    i.set(1);
                }
                else{
                    Toast.makeText(context, "Teacher Does not Exist", Toast.LENGTH_SHORT).show();
                    i.set(0);
                }

            }
            else{
                Toast.makeText(context, "Wrong Teacher_ID/Name/Phone...", Toast.LENGTH_SHORT).show();
                i.set(0);
            }
        });
        if(i.get()==1) return true;
        return false;
    }




}
