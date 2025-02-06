<template>
  <v-container fluid>
    <v-row class="pa-0 fill-height d-flex" no-gutters>
      <v-navigation-drawer theme="dark" permanent rail style="min-height: 600vh">
        <v-list-item prepend-avatar="mdi-account-circle" nav></v-list-item>
        <v-divider></v-divider>
        <v-list density="compact" nav>
          <v-list-item prepend-icon="mdi-view-dashboard" value="dashboard"></v-list-item>
          <v-list-item prepend-icon="mdi-forum" value="messages"></v-list-item>
          <v-list-item prepend-icon="mdi-account-circle" value="settings"></v-list-item>
        </v-list>
      </v-navigation-drawer>

      <v-navigation-drawer theme="dark" permanent>
        <v-list>
          <v-col>
            <h2>Praktikantenamt</h2>
            <v-spacer></v-spacer>
            <v-divider></v-divider>

            <div class="v-btn">
              <router-link to="./ApiTest.vue"> Router Test</router-link>
            </div>
            <v-list-item-title class="font-weight-bold">Überblick</v-list-item-title>

            <v-list-item title="Aufgaben" value="home" @click="openTasksDialog"></v-list-item>


            <v-list-item title="Probleme" value="problems"></v-list-item>
            <v-list-item title="Statistiken" value="statistics" @click="openStatisticsDialog"></v-list-item>
          </v-col>
          <v-col>
            <v-divider></v-divider>
            <v-list-item-title class="font-weight-bold">Status</v-list-item-title>
            <v-checkbox v-model="filters.status.zugelassen" color="green" density="compact"
                        label="Zugelassen"></v-checkbox>
            <v-checkbox v-model="filters.status.abgelehnt" color="red" density="compact" label="Abgelehnt"></v-checkbox>
            <v-checkbox v-model="filters.status.verschoben" color="yellow" density="compact"
                        label="Verschoben"></v-checkbox>
          </v-col>
          <v-col>
            <v-divider></v-divider>
            <v-list-item-title class="font-weight-bold">Phase</v-list-item-title>
            <v-checkbox v-model="filters.phase.anmeldung" color="brown" density="compact"
                        label="Anmeldung"></v-checkbox>
            <v-checkbox v-model="filters.phase.imPraxissemester" color="blue" density="compact"
                        label="Im Praxissemester"></v-checkbox>
            <v-checkbox v-model="filters.phase.abgeschlossen" color="purple" density="compact"
                        label="Abgeschlossen"></v-checkbox>
            <v-checkbox v-model="filters.phase.abgebrochen" color="orange" density="compact"
                        label="Abgebrochen"></v-checkbox>
          </v-col>
          <v-col>
            <v-divider></v-divider>
            <v-list-item-title class="font-weight-bold">Extra</v-list-item-title>
            <v-checkbox v-model="filters.extra.stelleVorhanden" color="grey" density="compact"
                        label="Stelle vorhanden"></v-checkbox>
            <v-checkbox v-model="filters.extra.grundstudiumBestanden" color="grey" density="compact"
                        label="Grundstudium bestanden"></v-checkbox>
          </v-col>
        </v-list>
      </v-navigation-drawer>


      <v-container class="pa-0 fill-height d-flex" style="align-items: flex-start; justify-content: flex-start;">
        <v-card rounded="0" class="flex-grow-1" theme="dark" width="100%"
                style="margin-top: -35px; margin-left: -32px; margin-right: -32px; min-height: 1000vh;">
          <template v-slot:text>
            <v-text-field v-model="search" label="Search" prepend-inner-icon="mdi-magnify" variant="outlined"
                          hide-details single-line></v-text-field>
          </template>

          <v-data-table
              :headers="headers"
              :items="filteredStudents"
              :search="search"
              item-key="name"
              class="elevation-1"
          >
            <template v-slot:headers="{ columns }">
              <tr>
                <th v-for="column in columns" :key="column.text" class="text-left">
                  {{ column.text }}
                </th>
              </tr>
            </template>

            <template v-slot:item="{ item }">
              <tr @click="rowClick(item)" style="cursor: pointer;">
                <td>
                  <v-chip append-icon="mdi-account" :color="getStatusColor(item.status)">{{ item.name }}</v-chip>
                </td>
                <td>
                  <v-chip>{{ item.studiengang }}</v-chip>
                </td>
                <td>
                  <v-chip>{{ item.semester }}</v-chip>
                </td>
                <td>
                  <v-chip>{{ item.firma }}</v-chip>
                </td>
                <td>
                  <v-chip :color="getStatusColor(item.status)">{{ item.status }}</v-chip>
                </td>
                <td>
                  <v-chip :color="getPhaseColor(item.phase)">{{ item.phase }}</v-chip>
                </td>


              </tr>
            </template>
          </v-data-table>

        </v-card>
      </v-container>

    </v-row>
  </v-container>


  <!-- Abgabe Dialog -->
  <v-dialog v-model="abgabeDialog" transition="slide-x-reverse-transition" fullscreen theme="dark" :value="true">
    <v-card>
      <v-toolbar>
        <v-toolbar-title>Abgaben</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn text="Schließen" @click="abgabeDialog = false"></v-btn>
        </v-toolbar-items>
      </v-toolbar>
      <v-card>
        <v-card-title>
          Antrag auf Zulassung
        </v-card-title>
        <v-card-text>
          <v-col>
            <v-row>
              <v-col cols="12" md="6">
                <v-text-field disabled label="Name"></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field disabled label="Matrikelnummer"></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="12" md="6">
                <v-text-field disabled label="Studiengang"></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field disabled label="Semester"></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="12" md="6">
                <v-text-field disabled label="Grundstudium"></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field disabled label="Praxistelle"></v-text-field>
              </v-col>
            </v-row>

            <v-checkbox disabled label="Ich möchte das Praxissemester machen"></v-checkbox>
          </v-col>
          <v-divider></v-divider>
          <v-row justify="end" style="margin-right: 30px; margin-top: -60px">
            <v-btn color="orange" variant="flat" @click="abgabeDialog = false">Ablehnen</v-btn>
            <v-btn color="green" variant="flat" @click="abgabeDialog = false">Annehmen</v-btn>
          </v-row>
        </v-card-text>


      </v-card>
    </v-card>
  </v-dialog>


  <!-- Aufgaben Dialog -->
  <v-dialog v-model="taskDialog" transition="slide-x-reverse-transition" fullscreen theme="dark">
    <v-card width="1200">
      <v-toolbar>
        <v-toolbar-title>Aufgaben</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn text="Schließen" @click="taskDialog = false"></v-btn>
        </v-toolbar-items>
      </v-toolbar>

      <v-card-text>
        <v-layout class="overflow-visible" style="height: 56px;">

          <div>

            <v-card
                class="mx-auto"
                style="width: 600%; max-width: 1800px;"

            >
              <v-list
                  :items="tasks"
                  lines="three"
                  item-props
              >
                <template v-slot:subtitle="{ subtitle }">
                  <div v-html="subtitle"></div>
                  <v-btn color="yellow" text="Open" @click="openAbgabeDialog"></v-btn>
                </template>
              </v-list>
            </v-card>
          </div>

        </v-layout>


      </v-card-text>
    </v-card>
  </v-dialog>


  <!-- Student Dialog -->
  <v-dialog v-model="studentDialog" transition="slide-x-reverse-transition" fullscreen theme="dark">
    <v-card width="1200">
      <v-toolbar>
        <v-toolbar-title>Student</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn text="Schließen" @click="studentDialog = false"></v-btn>
        </v-toolbar-items>
      </v-toolbar>

      <v-card-text>
        <v-row>


          <v-col cols="7">
            <v-card>
              <v-tabs v-model="tab" bg-color="black">
                <v-tab value="info">Info</v-tab>

                <v-tab value="abgaben">Abgaben</v-tab>
                <v-tab value="firmendetails">Firmendetails</v-tab>
                <v-tab value="studienleistung">Studienleistung</v-tab>

              </v-tabs>

              <v-card-text>
                <v-tabs-window v-model="tab">
                  <v-tabs-window-item value="info">
                    <v-col><strong>Name:</strong> {{ selectedStudent.name }}</v-col>
                    <v-col><strong>Studiengang:</strong> {{ selectedStudent.studiengang }}</v-col>
                    <v-col><strong>Status:</strong> {{ selectedStudent.status }}</v-col>
                    <v-col><strong>Phase:</strong> {{ selectedStudent.phase }}</v-col>
                    <v-col><strong>Firma:</strong> {{ selectedStudent.firma }}</v-col>
                  </v-tabs-window-item>


                  <v-tabs-window-item value="abgaben">
                    <v-list>
                      <v-list-item v-for="(abgabe, index) in selectedStudent.abgaben" :key="index">
                        <v-list-item-title>{{ abgabe }}</v-list-item-title>
                      </v-list-item>
                    </v-list>
                  </v-tabs-window-item>


                  <v-tabs-window-item value="firmendetails" v-if="selectedStudent.firmendetails">
                    <h3>Firma</h3>
                    <v-col class="small-gap"><strong>Name:</strong> {{ selectedStudent.firmendetails.name }}</v-col>
                    <v-col class="small-gap"><strong>Adresse:</strong> {{ selectedStudent.firmendetails.adresse }}
                    </v-col>
                    <v-col class="small-gap"><strong>Zeitraum:</strong> {{ selectedStudent.firmendetails.zeitraum }}
                    </v-col>
                    <h3>Kontaktperson</h3>
                    <v-col><strong>Name:</strong> {{ selectedStudent.firmendetails.kontakt.name }}</v-col>
                    <v-col><strong>Email:</strong> {{ selectedStudent.firmendetails.kontakt.email }}</v-col>
                  </v-tabs-window-item>

                  <v-tabs-window-item value="studienleistung">
                    <v-row dense>
                      <v-col><strong>Status:</strong> {{ selectedStudent.studienleistung.status }}</v-col>
                      <v-col><strong>Grundstudium ECTS:</strong> {{ selectedStudent.studienleistung.grundstudiumECTS }}
                      </v-col>
                      <v-col><strong>Hauptstudium ECTS:</strong> {{ selectedStudent.studienleistung.hauptstudiumECTS }}
                      </v-col>
                    </v-row>
                  </v-tabs-window-item>


                </v-tabs-window>
              </v-card-text>
            </v-card>
          </v-col>
          <v-col cols="5">
            <v-banner color="black"></v-banner>
            <h2>
              <v-banner-text>Timeline</v-banner-text>
            </h2>
            <v-card>
              <v-list>
                <v-list-item>
                  <v-timeline align="start" side="end">
                    <v-timeline-item dot-color="green" size="small">
                      <div class="d-flex">
                        <strong class="me-4">31.03.25</strong>
                        <div>
                          <strong>Angemeldet</strong><br>Angemeldet für das Praxissemester.
                        </div>
                      </div>
                    </v-timeline-item>

                    <v-timeline-item dot-color="red" size="small">
                      <div class="d-flex">
                        <strong class="me-4">7.05.25</strong>
                        <div>
                          <strong>Antrag auf Zulassung </strong><br>Antrag auf Zulassung abgegeben.
                        </div>
                      </div>
                    </v-timeline-item>
                  </v-timeline>
                </v-list-item>
              </v-list>
            </v-card>

          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </v-dialog>

  <v-dialog v-model="statisticsDialog" transition="slide-x-reverse-transition" fullscreen theme="dark">
    <v-card width="1200">
      <v-toolbar>
        <v-toolbar-title>Statistiken</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn text="Schließen" @click="statisticsDialog = false"></v-btn>
        </v-toolbar-items>
      </v-toolbar>

      <v-card-text>
        <div>
          {{ phaseCounts.anmeldung }}<br>
          {{ phaseCounts.imPraxissemester }}<br>
          {{ phaseCounts.abgeschlossen }}<br>
          {{ phaseCounts.abgebrochen }}<br>
        </div>
      </v-card-text>
    </v-card>
  </v-dialog>


</template>

<script>
import {students} from './studentData.js';
import {tasks} from './taskData.js';
import {headers} from './headerData.js';
import {calculatePhaseCounts, filteredStudents, filters, getPhaseColor, getStatusColor} from './filterData.js';


export default {
  data() {
    return {
      students,
      tasks,
      headers,
      filters,
      search: "",
      studentDialog: false,
      abgabeDialog: false,
      statisticsDialog: false,
      value: 'open',
      color: 'grey',
      taskDialog: false,
      tab: null,
      selectedStudent: {},
    };
  },
  computed: {
    filteredStudents() {
      return filteredStudents(this.students, this.filters);
    },
    phaseCounts() {
      return calculatePhaseCounts(this.students);
    },
  },
  methods: {
    openAbgabeDialog() {
      this.abgabeDialog = true;
    },

    openStatisticsDialog() {
      this.statisticsDialog = true;
    },

    openTasksDialog() {
      this.taskDialog = true;
    },
    openTestPage() {
      this.$router.push('/test')
    },


    rowClick(item) {
      this.selectedStudent = item;
      this.studentDialog = true;
    },
    getStatusColor,
    getPhaseColor,
  }
}

</script>

