// studentsData.js

export const students = [
    {
        name: "Student 1",
        studiengang: "AI",
        status: "zugelassen",
        phase: "Im Praxissemester",
        firma: "GECKO",
        aufgaben: ["Aufgabe 1", "Aufgabe 2"],
        abgaben: ["Abgabe 1", "Abgabe 2"],
        firmendetails: {
            name: "GECKO",
            adresse: "Heilbronn",
            zeitraum: "16.09.24 - 28.02.25",
            kontakt: {
                name: "Kontaktperson",
                email: "kontaktEmail@gmail.com"
            }
        },
        studienleistung: {
            status: "BE",
            grundstudiumECTS: 45,
            hauptstudiumECTS: 30
        },
        kontaktperson: {
            name: "Praktikantenamtsleiter",
            email: "leiter@gmail.com"
        }
    },
    {
        name: 'Student 2',
        studiengang: 'AI',
        status: 'zugelassen',
        phase: 'Im Praxissemester',
        firma: 'Kaufland',
    },
    {
        name: 'Student 3',
        studiengang: 'AI',
        status: 'verschiebung',
        phase: 'Anmeldung',
        firma: 'keine',
    },
    {
        name: 'Student 4',
        studiengang: 'AI',
        status: 'abgelehnt',
        phase: 'Abgebrochen',
        firma: 'keine',
    },
    {
        name: 'Student 5',
        studiengang: 'AI',
        status: 'zugelassen',
        phase: 'Anmeldung',
        firma: 'GECKO',
    },
    {
        name: 'Student 6',
        studiengang: 'AI',
        status: 'zugelassen',
        phase: 'Im Praxissemester',
        firma: 'Google',
    }
];
