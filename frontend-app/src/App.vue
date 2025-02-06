<template>
  <v-app>

    <v-main>
      <v-container>
        <v-row>
          <v-col>
            <InternshipMainDashboard></InternshipMainDashboard>
            <router-view  />
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import InternshipMainDashboard from "@/components/InternshipMainDashboard.vue";
</script>


