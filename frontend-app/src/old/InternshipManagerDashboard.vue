<template>
  <v-tabs bg-color="indigo-darken-2" fixed-tabs>
    <v-tab text="Internship Manager Dashboard"></v-tab>
  </v-tabs>

  <v-container>
    <h1>Leiter</h1>
    <v-row>
      <v-col>
        <v-combobox
            variant="solo"
            :items="semestersCombo"
            label="Semester"
            v-model="selectedSemester"
        ></v-combobox>
      </v-col>
      <v-col>
        <v-text-field
            disabled
            variant="solo">
          Studiengang: {{ valueStudyProgram }}
        </v-text-field>
      </v-col>
      <v-col>
        <v-text-field
            disabled
            variant="solo">
          Studenten: {{ currentData.students }}
        </v-text-field>
      </v-col>
    </v-row>
  </v-container>

  <v-container>
    <v-row>

      <v-col>
        <v-card
            color="grey lighten-2"
            class="mx-auto"
            elevation="16"
            style="width: 300px; margin-bottom: 10px; height: 320px"
        >
          <v-row>
            <v-card-item class="d-flex justify-start">
              <v-chip class="ma-2" color="yellow" variant="flat" elevation="1">
                Offen: {{ currentData.open }}
                <v-icon icon="mdi-minus-circle" end></v-icon>
              </v-chip>
              <v-btn
                  color="indigo-darken-2"
                  size="small"
                  variant="tonal"
                  elevation="1"
                  style="position: absolute; bottom: 10px; right: 10px;"
              >
                View Open
                <v-icon color="yellow" end>mdi-open-in-new</v-icon>
              </v-btn>
            </v-card-item>
          </v-row>
        </v-card>
      </v-col>


      <v-col>
        <v-card
            color="grey lighten-2"
            class="mx-auto"
            elevation="16"
            style="width: 300px; margin-bottom: 10px; height: 320px"
        >
          <v-row>
            <v-card-item class="d-flex justify-start">
              <v-chip class="ma-2" color="green" variant="flat" elevation="1">
                Abgeschlossen: {{ currentData.done }}
                <v-icon icon="mdi-checkbox-marked-circle" end></v-icon>
              </v-chip>
              <v-btn
                  color="indigo-darken-2"
                  size="small"
                  variant="tonal"
                  elevation="1"
                  style="position: absolute; bottom: 10px; right: 10px;"
              >
                View Completed
                <v-icon color="yellow" end>mdi-open-in-new</v-icon>
              </v-btn>
            </v-card-item>
          </v-row>
        </v-card>
      </v-col>


      <v-col>
        <v-card
            color="grey lighten-2"
            class="mx-auto"
            elevation="16"
            style="width: 300px; margin-bottom: 10px; height: 320px; position: relative;"
        >
          <v-row>
            <v-card-item class="d-flex justify-start">
              <v-chip class="ma-2" color="red" variant="flat" elevation="1">
                Abgelehnt: {{ currentData.closed }}
                <v-icon icon="mdi-cancel" end></v-icon>
              </v-chip>
            </v-card-item>
          </v-row>
          <v-btn
              color="indigo-darken-2"
              size="small"
              variant="tonal"
              elevation="1"
              style="position: absolute; bottom: 10px; right: 10px;"
          >
            View Rejected
            <v-icon color="yellow" end>mdi-open-in-new</v-icon>
          </v-btn>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { reactive, ref, computed } from "vue";


const semestersCombo = ["4", "5", "6", "7", "8", "9"];


const valueStudyProgram = "AI";


const semestersData = reactive({
  4: { students: 33, open: 22, done: 10, closed: 1 },
  5: { students: 22, open: 15, done: 5, closed: 2 },
  6: { students: 30, open: 20, done: 7, closed: 3 },
  7: { students: 25, open: 18, done: 6, closed: 1 },
  8: { students: 27, open: 12, done: 10, closed: 5 },
  9: { students: 20, open: 14, done: 4, closed: 2 },
});


const selectedSemester = ref(4);


const currentData = computed(() => semestersData[selectedSemester.value]);
</script>
