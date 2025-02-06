<template>
  <v-tabs bg-color="indigo-darken-2" fixed-tabs>
    <v-tab text="Student Dashboard"> </v-tab>
  </v-tabs>
  <v-container>
    <v-row>
      <v-col cols="4">
        <v-combobox
            v-model="selectedBaseStudy"
            :items="baseStudyStatus"
            label="Grundstudium"
        ></v-combobox>
      </v-col>

      <v-col cols="4">
        <v-combobox
            v-model="selectedInternshipPlace"
            :items="internshipPlaceComboBox"
            label="Praxisstelle"
        ></v-combobox>
      </v-col>
      <v-col cols="4">
        <v-combobox
            :items="selectAll"
            label="Auswahl"
        ></v-combobox>
      </v-col>
    </v-row>
  </v-container>
  <v-divider></v-divider>

  <v-container>
    <v-row justify="start">
      <v-col>
        <v-card max-width="770" max-height="1100" color="white" elevation="8">
          <v-virtual-scroll :items="filteredStudents" height="800" item-height="1150">
            <template v-slot:default="{ item }">
              <v-card color="grey" class="mx-auto" style="width: 700px; margin-top: 30px; margin-bottom: 10px; height: 120px" elevation="8">
                <v-card-item>
                  <v-container>
                    <v-row style="margin-bottom: 5px;">
                      <v-col>
                        <div class="text-h10" style="color: black;">{{ item.studentName }}</div>
                      </v-col>
                      <v-col>
                        <div class="text-h10" style="color: black;">Studiengang: {{ item.studyProgram }}</div>
                      </v-col>
                      <v-col>
                        <div class="text-h10" style="color: black;">Semester: {{ item.studySemester }}</div>
                      </v-col>
                      <v-col>
                        <v-btn color="indigo-darken-2" size="small" variant="tonal" elevation="1">
                          View Student
                          <v-icon color="yellow" end>
                            mdi-open-in-new
                          </v-icon>
                        </v-btn>
                      </v-col>
                    </v-row>
                    <v-row style="margin-top: 5px;">
                      <v-col>
                        <div class="text-h18" style="color: black;">Grundstudium: {{ item.baseStudy }}</div>
                      </v-col>
                      <v-col>
                        <div class="text-h18" style="color: black;">Praktikumsplatz: {{ item.internshipPlace }}</div>
                      </v-col>
                      <v-col>
                        <div class="text-h18" style="color: black;"></div>
                      </v-col>
                      <v-checkbox color="yellow" ></v-checkbox>
                    </v-row>
                  </v-container>
                </v-card-item>
              </v-card>
            </template>
          </v-virtual-scroll>
        </v-card>
      </v-col>
    </v-row>
  </v-container>

  <v-container>
    <v-row style="margin-top: -830px; margin-left: 795px;">
      <v-btn color="indigo-darken-2" style="width: 780px; height: 40px;"> Zulassen </v-btn>
    </v-row>
    <v-row style="margin-top: 15px; margin-left: 795px;">
      <v-btn color="indigo-darken-2" style="width: 780px; height: 40px;"> Ablehnen</v-btn>
    </v-row>
    <v-row style="margin-top: 15px; margin-left: 795px;">
      <v-btn color="indigo-darken-2" style="width: 780px; height: 40px;"> Löschen</v-btn>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref, computed } from 'vue'

const baseStudyStatus = ['Alle', 'BE', 'NB']
const internshipPlaceComboBox = ['Alle', 'Ja', 'Nein']
const selectAll = ['Alle', 'Keine']
const selectedBaseStudy = ref('Alle')
const selectedInternshipPlace = ref('Alle')
const students = [
  {
    studentName: "Student 1",
    studyProgram: "AI",
    studySemester: "4",
    baseStudy: "BE",
    internshipPlace: "Ja",

  },
  {
    studentName: "Student 2",
    studyProgram: "AI",
    studySemester: "4",
    baseStudy: "NB",
    internshipPlace: "Ja",

  },
  {
    studentName: "Student 3",
    studyProgram: "AI",
    studySemester: "4",
    baseStudy: "NB",
    internshipPlace: "Nein",

  },
  {
    studentName: "Student 4",
    studyProgram: "AI",
    studySemester: "4",
    baseStudy: "NB",
    internshipPlace: "Ja",
  },
  {
    studentName: "Student 5",
    studyProgram: "AI",
    studySemester: "4",
    baseStudy: "BE",
    internshipPlace: "Nein",
  },
  {
    studentName: "Student 6",
    studyProgram: "AI",
    studySemester: "4",
    baseStudy: "BE",
    internshipPlace: "Nein",
  }
]

const filteredStudents = computed(() => {
  return students.filter(student => {
    const matchesBaseStudy = selectedBaseStudy.value === 'Alle' || student.baseStudy === selectedBaseStudy.value
    const matchesInternshipPlace = selectedInternshipPlace.value === 'Alle' || student.internshipPlace === selectedInternshipPlace.value
    return matchesBaseStudy && matchesInternshipPlace
  })
})
</script>

