import React, {useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import {DataGrid} from '@mui/x-data-grid';

export default function BasicEditingGrid() {
    return (
        <div style={{ height: 300, width: '100%' }}>
            <DataGrid
                rows={rows}
                columns={columns}
                experimentalFeatures={{ newEditingApi: true }}
            />
        </div>
    );
}

const rows = [
    {
        id: 1,
        name: "serenay",
        surname: "celikkaya",
        email: "ser@cel.com",
        username : "sercel"
    }]

const columns = [
    {
        field: "id",
        headerName: "ID",
        width: 250,
        editable: true
    },
    {
        field: "name",
        headerName: "Name",
        width: 250,
        editable: true
    },
    {
        field: "surname",
        headerName: "Surname",
        width: 250,
        editable: true
    },
    {
        field: "email",
        headerName: "E-Mail",
        width: 250,
        editable: true
    },
    {
        field: "username",
        headerName: "Username",
        width: 250,
        editable: true
    },
]


export function ListStudents({students}) {

    return (
        <Box sx={{height: 400, width: '100%'}}>
            <DataGrid
                rows={students}
                columns={columns}
                pageSize={5}
                rowsPerPageOptions={[5]}
                checkboxSelection
                disableSelectionOnClick
            />
        </Box>
    );
}