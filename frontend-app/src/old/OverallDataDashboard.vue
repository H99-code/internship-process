<template>
  <v-card rounded="0">
    <h1>Overall</h1>
    <v-toolbar color="indigo-darken-2">
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <v-toolbar-title>Praxissemester Dashboard</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon="mdi-magnify"></v-btn>
      <v-btn icon="mdi-dots-vertical"></v-btn>
      <template v-slot:extension>
        <v-tabs v-model="tab" align-tabs="title">
          <v-tab
              v-for="item in items"
              :key="item.name"
              :value="item.name"
              :text="item.name"
          ></v-tab>
        </v-tabs>
      </template>
    </v-toolbar>

    <v-tabs-window v-model="tab">
      <v-tabs-window-item
          v-for="item in items"
          :key="item.name"
          :value="item.name"
      >
        <v-card flat height="473px" color="white">
          <v-card-title></v-card-title>
          <v-card-text>



            <template v-if="item.name === 'student'">
              <v-row>
                <v-row style="margin-left: 2px; margin-top: 30px; margin-right: 5px">
                  <v-col>
              <v-text-field variant="solo" disabled :value="student.firstname + ' ' + student.lastname"> </v-text-field>
              <v-text-field variant="solo" disabled :value="student.semester"></v-text-field>
              <v-text-field variant="solo" disabled :value="student.studyProgram"></v-text-field>
              <v-text-field variant="solo" disabled :value="student.studentNumber"></v-text-field>
              <v-text-field variant="solo" disabled :value="student.email"></v-text-field>
                  </v-col>
                </v-row>


                <v-row style="margin-left: 2px; margin-top: 10px; margin-right: 5px" >
                  <v-col>
                    Status:
              <v-text-field variant="solo" disabled>

                <v-chip color="green" variant="flat"> {{student.registeredStatus}} </v-chip> </v-text-field>

              <v-text-field variant="solo" disabled> <v-chip color="yellow" variant="flat"> {{student.internshipStatus}}  </v-chip> </v-text-field>
              Versuch:
                    <v-text-field variant="solo" disabled> <v-chip color="grey" variant="flat"> {{student.internshipAttempts}}  </v-chip> </v-text-field>
                  </v-col>
                </v-row>
              </v-row>
            </template>


















            <template v-else-if="item.name === 'aufgaben'">
              <v-container>
              <v-list >
              <v-card color="grey" elevation="8">
                <v-card-item>
                <v-card color="grey" height="70px">
                  <v-row>
                  <v-chip style="margin-left: 20px; margin-top: 30px" color = "green" variant="flat" > {{task.status}}
                  </v-chip>
                  <v-card-text style="margin-left: 440px;"  > {{task.name}} </v-card-text>
                  <v-card-text> due Date: {{task.dueDate}} </v-card-text>
                  <v-file-input style ="margin-top: 20px; margin-right: 20px"  variant="solo" label="File input"></v-file-input>
                  </v-row>
                </v-card>
                </v-card-item>
              </v-card>
              </v-list>
              </v-container>
            </template>








            <template v-else-if="item.name === 'abgaben'">

              <v-row justify="end">
                <v-card style="margin-top: 400px; margin-right: 20px" flat>
                <v-col>
                <v-btn color="indigo-darken-2">Bestätigen</v-btn>

                <v-btn color="indigo-darken-2">Ablehnen</v-btn>
                </v-col>
                </v-card>
              </v-row>


              <v-container>
                <v-list style="margin-top: -400px; " >
                  <v-card color="grey" elevation="8" width="80%" style="margin-top: 1px">
                    <v-card-item>
                      <v-card color="grey" height="70px">
                        <v-row>
                          <v-chip style="margin-left: 20px; margin-top: 30px" color = "green" variant="flat" > {{task.status}}
                          </v-chip>
                          <v-card-text style="margin-left: 440px;"  > {{task.name}} </v-card-text>
                          <v-card-text> due Date: {{task.dueDate}} </v-card-text>

                          <v-file-input style ="margin-top: 20px; margin-right: 20px"  variant="solo" label="File input"></v-file-input>
                          <v-checkbox style="margin-top: 20px; margin-right: 20px"></v-checkbox>
                        </v-row>
                      </v-card>
                    </v-card-item>
                  </v-card>
                </v-list>
              </v-container>
            </template>
            <template v-if="item.name === 'firma'">
              <v-text-field variant="solo" disabled :value="company.name"></v-text-field>
              <v-text-field variant="solo" disabled :value="company.address"> </v-text-field>
              <v-text-field variant="solo" disabled :value="company.period"> </v-text-field>
              Kontaktperson:
              <v-text-field variant="solo" disabled :value="company.contact.name"></v-text-field>
              <v-text-field variant="solo" disabled :value="company.contact.email"></v-text-field>
            </template>

            <template v-else-if="item.name === 'studienleistung'">
              <v-row>
              <v-text-field variant="solo" disabled :value="studyAchievements.base"></v-text-field>
              <v-text-field variant="solo" disabled :value="studyAchievements.baseEcts"></v-text-field>
              <v-text-field variant="solo" disabled :value="studyAchievements.totalEcts"></v-text-field>
              </v-row>
              <v-card  elevation="8">

                <v-text-field variant="solo" disabled :value="studyAchievements.examModule"></v-text-field>
                <v-text-field variant="solo" disabled :value="studyAchievements.examName1"></v-text-field>
                <v-text-field variant="solo" disabled :value="studyAchievements.examName2"></v-text-field>

              </v-card>
            </template>


            <template v-else-if="item.name === 'kontaktperson'">
               <v-container>
                 <v-row>
              <v-row align="end">
                <v-col>
                  <v-card width="90%"  elevation="8">
              Praktikantenamtsleiter:
              <v-text-field disabled variant="solo" :value="internshipManager.name"></v-text-field>
              <v-text-field disabled variant="solo" :value="internshipManager.email"></v-text-field>
              <v-text-field disabled variant="solo" :value="internshipManager.roomNumber"></v-text-field>
              <v-text-field disabled variant="solo" :value="internshipManager.studyProgramAffiliation"></v-text-field>
                  </v-card>
                </v-col>
                  </v-row>
              <v-row align="end">
                <v-col>
                  <v-card width = "90%"  elevation="8">
              Sekretariat:
              <v-text-field disabled variant="solo" :value="secretary.name"></v-text-field>
              <v-text-field disabled variant="solo" :value="secretary.email"></v-text-field>
              <v-text-field disabled variant="solo" :value="secretary.roomNumber"></v-text-field>
                    <v-text-field disabled variant="solo" :value="secretary.studyProgramAffiliation"> </v-text-field>
                  </v-card>
                </v-col>
              </v-row>
                 </v-row>
            </v-container>
            </template>



            <nav>
              <RouterLink to="/dashboard">Dashboard</RouterLink>
            </nav>



          </v-card-text>
        </v-card>
      </v-tabs-window-item>
    </v-tabs-window>
  </v-card>
</template>

<script>

export default {
  data() {
    return {
      tab: null,
      items: [
        {name: 'student', title: 'Studentendaten'},
        {name: 'aufgaben', title: 'Aufgaben'},
        {name: 'abgaben', title: 'Abgaben'},
        {name: 'firma', title: 'Firma'},
        {name: 'studienleistung', title: 'Studienleistungen'},
        {name: 'kontaktperson', title: 'Kontaktperson'},
      ],
      student: {
        firstname: 'Student',
        lastname: '1',
        studentNumber: '123456',
        semester: 5,
        studyProgram: 'AI',
        email: 'my@mail.com',
        internshipStatus: 'Im Praxissemester',
        registeredStatus: 'Zugelassen ',
        internshipAttempts: '1'
      },

      task: {
        name: 'Antrag auf Zulassung',
        dueDate: '30.07.24',
        status: 'DONE'
      },

      documents: [
        { name: 'Antrag auf Zulassung', submissionDate: '30.07.24', status: 'DONE' },
      ],
      company: {
        name: 'GECKO Institut',
        address: 'Heilbronn',
        period: '16.06.24 - 28.09.25',
        contact: {
          name: 'Supervisor 1',
          email: 'c@mail.com',
        },
      },
      studyAchievements: {
        base: 'BE',
        totalEcts: '99/210',
        baseEcts: '60/60',
        examModule: '123 Medieninformatik: BE',
        examName1: '123 MCI: BE',
        examName2: '123 DM: BE',
      },
      internshipManager: {
        name: ' Internship Manager 1',
        email: 'another@mail.com',
        roomNumber: 'A210',
        studyProgramAffiliation: 'AI',
      },
      secretary: {
        name: 'Secretary 1',
        email: 's@mail.com',
        roomNumber: 'A210',
        studyProgramAffiliation: 'AI',
      },
    };
  },
};

</script>
