package com.example.aman.to_doapp.viewmodels;

import android.content.Intent;

/**
 * Created by Aman on 2/15/17.
 */

public class EditTodoViewModel {

    public String name;
    public String content;


    public boolean validate() {
        return name != null && content != null;
    }

    public Intent makeIntent() {
        Intent intent = new Intent();
        intent.putExtra("NAME", name);
        intent.putExtra("CONTENTS", content);
        return intent;
    }
}
