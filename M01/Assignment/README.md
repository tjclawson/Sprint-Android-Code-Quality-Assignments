# Android_Debug_NoteTaker

## Introduction

This goal of this project is to debug a Note Taker project. As this is a project specifically intended to help you practice your debugging skills and using the resources available to you, refrain from asking for help unless absolutely necessary.

## Instructions

Please fork and clone this repository. It contains the broken project that you should debug. As this is a project that you have worked on previously, do not use your own completed version of this project as you will gain nothing (in the long term) from referencing it.

As a recap, the project when working properly should:

- Allow the user to create notes that are saved to a Firebase Database and an on-device persistent store using an SQL database
- The device's persistent store is synchronized with the Firebase Database. (When a journal entry is saved to the device's persistent store it gets sent to Firebase, and vice-versa.

##Fixed Bugs

1. No default activity
	add activities to Manifest.xml

2. XML
	fix tools:context in activity_edit.xml and activity_main.xml

3. build.gradle
	add implementation 'androidx.constraintlayout:constraintlayout:1.1.3' dependency

4. Unresolved references in pref_headers.xml
	create drawable icons

5. NoteViewModel.kt
	line 21 pass context to NoteRepository

6. SharedPrefsDao.kt
	change note.getID and note.setID to note.id.toString()

7. NotesDbDao.kt
	change all getId() to id 

8. Note.kt
	comment out `private set` on line 20 and
```
constructor(id: Long) {
        this.id = id
    }
```
on line 57

9. activity_main.xml
	re-add recyclerview on line 48

10. NotesDbHelper.kt
	Change DATABASE_VERSION to 1 line 23

11. EditActivity.kt
	make cast to note nullable line 21

12. note_element_layout.xml
	re-add cardview
