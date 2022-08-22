import React from "react";
import {useEffect, useState} from "react";
import {AppBar, Button, IconButton} from "@mui/material";
import {toast} from "react-toastify";
import {AddAsistan} from "./AddAsistan/AddAsistan";
import {AsistanViewApi} from "./API/AsistanViewApi";
import Toolbar from "@mui/material/Toolbar";
import Box from "@mui/material/Box";
import {DataGrid} from "@mui/x-data-grid";
import DeleteIcon from '@mui/icons-material/Delete'



export function AsistanView() {

    const [asistan, setAsistan] = useState([]);
    const [isAddAsistanDialogOpen, setAddAsistanDialogOpen] = useState(false);
    const [selectionModel, setSelectionModel] = useState();
    const asistanViewApi = new AsistanViewApi();

    async function getAsistan() {
        const response = await asistanViewApi.getAsistan();
        setAsistan(response.data);
    }

    useEffect(() => {
        getAsistan().then();
    }, [])

    async function addAsistan(formState) {
        const response = await asistanViewApi.addAsistan(formState);
        const messageResponse = response.data;
        if (messageResponse.responseType === "SUCCESS") {
            toast.success(messageResponse.message);
            setAddAsistanDialogOpen(false);
        }
    }

    async function deleteCell(e){
        e.preventDefault();
        console.log("id" + selectionModel)
        const selectedIDs = selectionModel;
        try {
            const response = await asistanViewApi.deleteAsistan(selectedIDs);
            const messageResponse = response.data;
            if (messageResponse.responseType === "SUCCESS") {
                toast.success(messageResponse.message);
                setAsistan((r) => r.filter((x) => !x.id===selectedIDs));
                getAsistan();
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
        const asistanIndex = asistan.findIndex(asistan => {
            return asistan.id === params.id;
        });


        const updateAsistan = [... asistan];
        updateAsistan[asistanIndex][params.field] = newValue;
        setAsistan(updateAsistan)

        const id = params.id;
        console.log(id);
        console.log(asistanIndex);
        console.log(updateAsistan[asistanIndex]);

        const response = await asistanViewApi.updateAsistan(id,updateAsistan[asistanIndex]);
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
                    <Button className="button" onClick={() => setAddAsistanDialogOpen(true)}>Add Asistan</Button>
                </Toolbar>
            </AppBar>
            <h2>Asistan</h2>
            <Box sx={{height: 500, width: '80%', paddingLeft:15}}>
                <DataGrid
                    rows={asistan}
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
            <AddAsistan isOpen={isAddAsistanDialogOpen}
                          close={() => setAddAsistanDialogOpen(false)}
                          addAsistan={addAsistan()}
            />
        </div>
    )
}

export default AsistanView;