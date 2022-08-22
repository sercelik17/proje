import React, { useState } from "react";
import {AppBar} from "@mui/material";
import Toolbar from '@mui/material/Toolbar';
import {Avatar} from "@mui/material";
import {Button} from "@mui/material";
import {ExamApi} from "./API/ExamViewApi";
import { useEffect } from "react";
import Box from '@mui/material/Box';
import {DataGrid} from '@mui/x-data-grid';
import {AddExam} from "./AddExam/AddExam";
import {toast} from "react-toastify";


function ExamView() {
    const [exams, SetExams] = useState([]);
    const [isAddExamDialogOpen, setAddExamDialogOpen] = useState(false);
    const examApi = new ExamApi();

    async function getExams() {
        const response = await examApi.getExams();
        SetExams(response.data);
    }

    useEffect(() => {
        getExams().then();
    }, []);

    async function addExam(formState) {
        const response = await examApi.addExam(formState);
        const messageResponse = response.data;
        if (messageResponse.responseType === "SUCCESS") {
            toast.success(messageResponse.message);
            setAddExamDialogOpen(false);
        }
    }

    const columns = [
        {
            field: "id",
            headerName: "ID",
            width: 200,
        },
        {
            field: "name",
            headerName: "Name",
            width: 200,
        },
        {
            field: "time",
            headerName: "Time",
            width: 200,
        },
        {
            field: "room",
            headerName: "Room",
            width: 200,
        },
        {
            field: "info",
            headerName: "Info",
            width: 200,
        },
        {
            field: "lesson_id",
            headerName: "Lesson_ID",
            width: 200,
        },
    ]

    return(
        <div>
            <AppBar  className="appbar" position="static" color="secondary" >
                <Toolbar>
                    <Button className="button" onClick={() => setAddExamDialogOpen(true)}>Add Exam</Button>
                </Toolbar>
            </AppBar>
            <h2>Exams</h2>
            <Box sx={{height: 400, width: '80%', marginLeft: 15}}>
                <DataGrid
                    rows={exams}
                    columns={columns}
                    pageSize={5}
                    rowsPerPageOptions={[5]}
                    checkboxSelection
                    disableSelectionOnClick
                />
            </Box>
            <AddExam isOpen={isAddExamDialogOpen}
                     close={() => setAddExamDialogOpen(false)}
                     addExam={addExam}
            />
        </div>
    );
}
export default ExamView;