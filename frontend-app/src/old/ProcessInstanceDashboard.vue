<template>
  <v-tabs bg-color="indigo-darken-2" fixed-tabs>
    <v-tab text="Process Dashboard"> </v-tab>
  </v-tabs>

  <v-container>
    <v-row justify="end" style="margin-top: -10px; margin-right: 50px">
      <v-card width="75%" color="white" variant="flat">
        <v-card-item>
          <v-row>
            <v-col cols="4">
              <v-combobox :items="statusCombo" label="Status"></v-combobox>
            </v-col>
            <v-col cols="4">
              <v-combobox :items="dueDateCombo" label="Fälligkeitsdatum"></v-combobox>
            </v-col>
            <v-col cols="4">

              <v-btn color="indigo-darken-2" @click="goToManagerDashboard">Archivieren</v-btn>
            </v-col>
          </v-row>
        </v-card-item>
      </v-card>
    </v-row>
  </v-container>

  <v-container>
    <v-row justify="start" style="margin-top: -110px;">
      <v-card width="20%" height="400px" color="white" variant="flat">
        <v-row>
          <v-col>
            <v-text-field disabled>{{ processAssignee }}</v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-text-field disabled>{{ userName }}</v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-text-field disabled>{{ processId }}</v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col>
            <v-btn color="indigo-darken-2" style="margin-right: 10px">Log out</v-btn>
            <v-btn color="indigo-darken-2">Settings</v-btn>
          </v-col>
        </v-row>
      </v-card>
    </v-row>
  </v-container>

  <v-container width="67%" style="margin-top: -270px; margin-right: 100px; height: 800px;">
    <v-row>
      <v-card width="120%" height="600px" color="white" elevation="8">
        <v-list v-model:opened="open" height="400px">
          <v-list-group value="Praxissemester">
            <template v-slot:activator="{ props }">
              <v-list-item v-bind="props" :prepend-icon="icons.praxissemester" @click="toggleIcon('praxissemester')">
                <v-col style="margin-top: 20px;">
                  {{ processName }}
                </v-col>
                <v-col>
                  <v-row align="start" justify="end" style="margin-top: -40px;">
                    Open: {{ openProcess }} Done: {{ closedProcess }}
                  </v-row>
                </v-col>
              </v-list-item>
              <v-divider thickness="10"></v-divider>
            </template>

            <v-list-group value="Anmeldeprozess">
              <template v-slot:activator="{ props }">
                <v-list-item v-bind="props" :prepend-icon="icons.anmeldeprozess" @click="toggleIcon('anmeldeprozess')">
                  {{ processInstanceName1 }}
                  <v-col>
                    <v-row align="start" justify="end" style="margin-top: -40px;">
                      {{ dueDate }}
                      <v-chip class="ma-1" color="green" variant="flat">{{ closedProcessStatus }}</v-chip>
                      <v-checkbox></v-checkbox>
                    </v-row>
                  </v-col>
                </v-list-item>
              </template>

              <v-list-item v-for="([title, icon], i) in admins" :key="i" :prepend-icon="icon" :title="title" :value="title"></v-list-item>
            </v-list-group>

            <v-list-group value="Abgabeprozess">
              <template v-slot:activator="{ props }">
                <v-list-item v-bind="props" :prepend-icon="icons.abgabeprozess" @click="toggleIcon('abgabeprozess')">
                  {{ processInstanceName2 }}
                  <v-col>
                    <v-row align="start" justify="end" style="margin-top: -40px;">
                      {{ dueDate }}
                      <v-chip class="ma-1" color="yellow" variant="flat">{{ openProcessStatus }}</v-chip>
                      <v-checkbox></v-checkbox>
                    </v-row>
                  </v-col>
                </v-list-item>
              </template>

              <v-list-item v-for="([title, icon], i) in cruds" :key="i" :prepend-icon="icon" :title="title" :value="title"></v-list-item>
            </v-list-group>
          </v-list-group>
        </v-list>
      </v-card>
    </v-row>
  </v-container>
</template>

<script setup>
import {ref} from 'vue';
import {useRouter} from 'vue-router';

const router = useRouter();

const open = ref([]);


const statusCombo = ["DONE", "OPEN"];
const dueDateCombo = ["Ein", "Aus"];


const processName = "Praxissemester";
const processInstanceName1 = "Anmeldeprozess";
const processInstanceName2 = "Abgabeprozess";
const processId = "12345";
const userName = "u.name";
const processAssignee = "User";
const dueDate = "22.02.22";
const openProcess = 1;
const openProcessStatus = "OPEN";
const closedProcessStatus = "DONE";
const closedProcess = 1;


const icons = ref({
  praxissemester: 'mdi-plus-box',
  anmeldeprozess: 'mdi-plus-box',
  abgabeprozess: 'mdi-plus-box'
});


const toggleIcon = (group) => {
  icons.value[group] = icons.value[group] === 'mdi-plus-box' ? 'mdi-minus-box' : 'mdi-plus-box';
};


const goToManagerDashboard = () => {
  router.push('/manager-dashboard');
};
</script>
