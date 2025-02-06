
<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <h1>Student List</h1>
        <v-list>
          <v-list-item
              v-for="student in students"
              :key="student.id"
              @click="selectedStudent = student.id"
          >
            <v-list-item>
              <v-list-item-title>{{ student.name }}</v-list-item-title>
            </v-list-item>
          </v-list-item>
        </v-list>

      </v-col>

    </v-row>

    <v-row v-if="selectedStudent">
      <v-col cols="12">
        <h2>Student Details</h2>
        <v-text-field
            label="First Name"
            v-model="selectedStudent.firstName"
        ></v-text-field>
        <v-text-field
            label="Last Name"
            v-model="selectedStudent.lastName"
        ></v-text-field>
        <v-text-field
            label="Email Address"
            v-model="selectedStudent.emailAddress"
        ></v-text-field>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <h2>Add New Student</h2>
        <v-text-field
            label="First Name"
            v-model="newStudent.firstName"
        ></v-text-field>
        <v-text-field
            label="Last Name"
            v-model="newStudent.lastName"
        ></v-text-field>
        <v-text-field
            label="Email Address"
            v-model="newStudent.emailAddress"
        ></v-text-field>
        <v-btn @click="addStudent">Add Student</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      students: [],
      selectedStudent: null,
      hasSaved: false,
      newStudent: {
        firstName: '',
        lastName: '',
        emailAddress: '',
      },
      headers: [
        {title: 'First Name', value: 'firstName'},
        {title: 'Last Name', value: 'lastName'},
        {title: 'Email Address', value: 'emailAddress'}
      ],
    };
  },
  created() {
    this.loadStudents();
  },
  watch: {
    selectedStudent(newStudentId) {
      if (newStudentId) {
        this.loadStudentDetails(newStudentId);
      }
    },
  },
  methods: {
    async loadStudents() {
      try {
        const response = await fetch('http://localhost:3000/students');
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        this.students = data._embedded.students.map(student => ({
          id: student.personalNumber,
          name: `${student.firstName} ${student.lastName}`,
          firstName: student.firstName,
          lastName: student.lastName,
          emailAddress: student.emailAddress
        }));
      } catch (error) {
        console.error('Fehler beim Abrufen der Daten:', error);
      }
    },
    async loadStudentDetails(studentId) {
      const response = await fetch(`http://localhost:3000/students/${studentId}`);
      const data = await response.json();
      this.selectedStudent = {
        firstName: data.firstName,
        lastName: data.lastName,
        emailAddress: data.emailAddress
      };
    },
    async addStudent() {
      const newStudent = {
        firstName: this.newStudent.firstName,
        lastName: this.newStudent.lastName,
        emailAddress: this.newStudent.emailAddress,
      };
      const response = await fetch('http://localhost:3000/students', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(newStudent),
      });
      if (response.ok) {
        this.loadStudents();
        this.newStudent = {firstName: '', lastName: '', emailAddress: ''};
        this.hasSaved = true;
      } else {
        console.error('Error adding student');
      }
    }
  },
};
</script>


