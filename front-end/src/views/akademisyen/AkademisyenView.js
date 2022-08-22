import React from "react";
import {useEffect, useState} from "react";
import {AppBar, Button, IconButton} from "@mui/material";
import {toast} from "react-toastify";
import {AddAkademisyen} from "./AddAkademisyen/AddAkademisyen";

import {AkademisyenViewApi} from "./API/AkademisyenViewApi";

import Toolbar from "@mui/material/Toolbar";
import {DataGrid} from "@mui/x-data-grid";
import Box from "@mui/material/Box";

import DeleteIcon from '@mui/icons-material/Delete'



export function AkademisyenView() {

    const [akademisyen, setAkademisyen] = useState([]);
    const [isAddAkademisyenDialogOpen, setAddAkademisyenDialogOpen] = useState(false);
    const [selectionModel, setSelectionModel] = useState();
    const akademisyenViewApi = new AkademisyenViewApi();

    async function getAkademisyen() {
        const response = await akademisyenViewApi.getAkademisyen();
        setAkademisyen(response.data);
    }

    useEffect(() => {
        getAkademisyen().then();
    }, []);

    async function addAkademisyen(formState) {
        const response = await akademisyenViewApi.addAkademisyen(formState);
        const messageResponse = response.data;
        if (messageResponse.responseType === "SUCCESS") {
            //toast.success(messageResponse.message);
            setAddAkademisyenDialogOpen(false);
        }
    }

    async function deleteCell(e){
        e.preventDefault();
        console.log("id" + selectionModel)
        const selectedIDs = selectionModel;
        try {
            const response = await akademisyenViewApi.deleteAkademisyen(selectedIDs);
            const messageResponse = response.data;
            if (messageResponse.responseType === "SUCCESS") {
                toast.success(messageResponse.message);
                setAkademisyen((r) => r.filter((x) => !x.id===selectedIDs));
                getAkademisyen().then();
                console.log(messageResponse)
            }
            else{
                toast.error(messageResponse.message);
                console.log(messageResponse)
            }
        }catch (error) {
            console.log(error.response.status)
            toast.error("Please select id");
        }
    }

    async function handleCellChange(params, newValue) {
        const akademisyenIndex = akademisyen.findIndex(academician => {
            return akademisyen.id === params.id;
        });


        const updateAkademisyen = [... akademisyen];
        updateAkademisyen[akademisyenIndex][params.field] = newValue;
        setAkademisyen(updateAkademisyen)

        const id = params.id;
        console.log(id);
        console.log(akademisyenIndex);
        console.log(updateAkademisyen[akademisyenIndex]);

        const response = await akademisyenViewApi.updateAkademisyen(id,updateAkademisyen[akademisyenIndex]);
        const messageResponse = response.data;
    }



    const columns = [
        {
            field: "id",
            headerName: "ID",
            width: 150,
            editable: false,
        },
        {
            field: "name",
            headerName: "Name",
            width: 150,
            editable: true,
        },
        {
            field: "surname",
            headerName: "Surname",
            width: 150,
            editable: true,
        },
        {
            field: "username",
            headerName: "Username",
            width: 150,
            editable: true,
        },
        {
            field: "password",
            headerName: "Password",
            width: 150,
            editable: true,
        },
        {
            field: "delete",
            width: 75,
            disableColumnMenu: true,
            renderHeader: () => {
                return (
                    <IconButton
                        onClick={deleteCell}
                    >
                        <DeleteIcon color="secondary" />
                    </IconButton>
                );
            }
        },
    ]

    return (
        <div>
            <AppBar  className="appbar" position="static" color="secondary" >
                <Toolbar>
                    <Button className="button" onClick={() => setAddAkademisyenDialogOpen(true)}>Add Akademisyen</Button>
                </Toolbar>
            </AppBar>
            <h2>Akademisyen</h2>
            <Box sx={{height: 500, width: '80%', paddingLeft:15}}>
                <DataGrid
                    rows={akademisyen}
                    columns={columns}
                    pageSize={5}
                    rowsPerPageOptions={[5]}
                    experimentalFeatures={{ newEditingApi: true }}
                    onCellEditStop={(params,event) =>handleCellChange(params, event.target.value)}
                    checkboxSelection
                    selectionModel={selectionModel}
                    hideFooterSelectedRowCount
                    onSelectionModelChange={(selection) => {
                        if (selection.length > 1) {
                            const selectionSet = new Set(selectionModel);
                            const result = selection.filter((s) => !selectionSet.has(s));

                            setSelectionModel(result);
                        } else {
                            setSelectionModel(selection);
                        }
                    }}
                />
            </Box>
            <AddAkademisyen isOpen={isAddAkademisyenDialogOpen}
                            close={() => setAddAkademisyenDialogOpen(false)}
                            addAcademician={addAkademisyen()}
            />
        </div>
    )
}

export default AkademisyenView;