package com.example.navigation1.data

class NavRepository: Repository {
    private var studentList = mutableListOf<Student>(
        Student(
            id = 1,
            name = "John Doe",
            age = 20,
            grade = "A",
            email = "john@example.com"
        ),
        Student(
            id = 2,
            name = "Jane Smith",
            age = 22,
            grade = "B",
            email = "jane@example.com"
        ),
        Student(
            id = 3,
            name = "Bob Johnson",
            age = 21,
            grade = "A",
            email = "bob@example.com"
        ),
        Student(
            id = 4,
            name = "Alice Brown",
            age = 19,
            grade = "C",
            email = "alice@example.com"
        ),
        Student(
            id = 5,
            name = "Tom Wilson",
            age = 23,
            grade = "B",
            email = "tom@example.com"
        ),
        Student(
            id = 6,
            name = "Emily Davis",
            age = 20,
            grade = "A",
            email = "emily@example.com"
        ),
        Student(
            id = 7,
            name = "David Lee",
            age = 22,
            grade = "B",
            email = "david@example.com"
        ),
        Student(
            id = 8,
            name = "Sarah Garcia",
            age = 21,
            grade = "A",
            email = "sarah@example.com"
        ),
        Student(
            id = 9,
            name = "Michael Martinez",
            age = 19,
            grade = "C",
            email = "michael@example.com"
        ),
        Student(
            id = 10,
            name = "Jessica Hernandez",
            age = 23,
            grade = "B",
            email = "jessica@example.com"
        )
    )

    override fun getStudent(id: Int): Student {
        return studentList.find { it.id == id } ?: Student (
            id = 0,
            name = "No Data",
            age = 0,
            grade = "No Data",
            email = "No Data"
        )
    }

    override fun setStudent(student: Student) {
        studentList.add(student)
    }
}