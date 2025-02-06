

export const filters = {
    status: {
        zugelassen: false,
        abgelehnt: false,
        verschoben: false,
    },
    phase: {
        anmeldung: false,
        imPraxissemester: false,
        abgeschlossen: false,
        abgebrochen: false,
    },
    extra: {
        stelleVorhanden: false,
        grundstudiumBestanden: false,
    }
};

export function calculatePhaseCounts(students) {
    return students.reduce((counts, student) => {
        if (student.phase === "Anmeldung") {
            counts.anmeldung++;
        } else if (student.phase === "Im Praxissemester") {
            counts.imPraxissemester++;
        } else if (student.phase === "Abgeschlossen") {
            counts.abgeschlossen++;
        } else if (student.phase === "Abgebrochen") {
            counts.abgebrochen++;
        }

        return counts;
    }, {
        anmeldung: 0,
        imPraxissemester: 0,
        abgeschlossen: 0,
        abgebrochen: 0,
    });
}


export function getStatusColor(status) {
    switch (status) {
        case "zugelassen":
            return "green";
        case "abgelehnt":
            return "red";
        case "verschiebung":
            return "yellow";
        default:
            return "grey";
    }
}

export function getPhaseColor(phase) {
    switch (phase) {
        case "Im Praxissemester":
            return "blue";
        case "Abgeschlossen":
            return "purple";
        case "Anmeldung":
            return "brown";
        case "Abgebrochen":
            return "orange";
        default:
            return "grey";
    }
}

export function filteredStudents(students, filters) {
    return students.filter(student => {
        let statusMatch = true;
        let phaseMatch = true;
        let extraMatch = true;



        if (filters.status.zugelassen) {
            statusMatch = student.status === "zugelassen";

        }
        if (filters.status.abgelehnt) {
            statusMatch = student.status === "abgelehnt";
        }
        if (filters.status.verschoben) {
            statusMatch = student.status === "verschiebung";
        }

        if (filters.phase.anmeldung) {
            phaseMatch = student.phase === "Anmeldung";
        }
        if (filters.phase.imPraxissemester) {
            phaseMatch = student.phase === "Im Praxissemester";
        }
        if (filters.phase.abgeschlossen) {
            phaseMatch = student.phase === "Abgeschlossen";
        }
        if (filters.phase.abgebrochen) {
            phaseMatch = student.phase === "Abgebrochen";
        }

        if (filters.extra.stelleVorhanden) {
            extraMatch = student.firma !== "keine";
        }
        if (filters.extra.grundstudiumBestanden) {
            extraMatch = student.studienleistung.status === "BE";
        }

        return statusMatch && phaseMatch && extraMatch;
    });
}
