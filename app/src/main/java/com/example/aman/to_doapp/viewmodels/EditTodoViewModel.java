package com.example.aman.to_doapp.viewmodels;

import android.content.Intent;

/**
 * Created by Aman on 2/15/17.
 */

public class EditTodoViewModel {

    public String name;
    public String content;
    public String dateCreated;
    public String dueDate;


    public boolean validate() {
        return name != null && content != null &&  dateCreated != null && dueDate != null;
    }

    public Intent makeIntent() {
        Intent intent = new Intent();
        intent.putExtra("NAME", name);
        intent.putExtra("CONTENTS", content);
        intent.putExtra("DATE CREATED", dateCreated);
        intent.putExtra("DUE DATE", dueDate);
        return intent;
    }
}
