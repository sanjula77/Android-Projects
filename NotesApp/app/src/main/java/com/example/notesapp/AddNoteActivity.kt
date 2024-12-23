import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.DatabaseInstance
import com.example.notesapp.Note
import com.example.notesapp.NoteDatabase
import com.example.notesapp.databinding.ActivityAddNoteBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {

    private lateinit var database: NoteDatabase
    private var noteId: Int? = null
    private lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = DatabaseInstance.getDatabase(this)

        noteId = intent.getIntExtra("note_id", -1).takeIf { it != -1 }
        if (noteId != null) {
            loadNoteForEditing(noteId!!)
        }

        binding.saveNoteButton.setOnClickListener {
            val title = binding.noteTitleEditText.text.toString().trim()
            val content = binding.noteContentEditText.text.toString().trim()

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            saveNote(title, content)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun loadNoteForEditing(noteId: Int) {
        GlobalScope.launch {
            val note = database.noteDao().getAllNotes().find { it.id == noteId }
            runOnUiThread {
                note?.let {
                    binding.noteTitleEditText.setText(it.title)
                    binding.noteContentEditText.setText(it.content)
                }
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun saveNote(title: String, content: String) {
        GlobalScope.launch {
            val note = Note(
                id = noteId ?: 0,
                title = title,
                content = content
            )
            database.noteDao().insert(note)

            runOnUiThread {
                Toast.makeText(this@AddNoteActivity, "Note saved successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
