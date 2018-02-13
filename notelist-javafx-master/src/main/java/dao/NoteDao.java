package dao;

import models.Note;

import java.util.List;

public interface NoteDao {

    List<Note> values ();
    Note find(Long id);
    Long add(Note note);
    void update (Note note);
    Integer delete (Long id);

}
