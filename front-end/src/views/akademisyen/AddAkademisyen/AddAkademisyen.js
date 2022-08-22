import * as React from "react";
import {useState} from "react";
import {Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField} from "@mui/material";

export function AddAkademisyen(props) {

    const [formState, setFormState] = useState({});

    function onFormInputChange(event) {
        const field = event.target.name;
        const value = event.target.value;
        const newState = {...formState};
        newState[field] = value;
        setFormState(newState);
    }


    return (
        <Dialog open={props.isOpen}>
            <DialogTitle>Add new akademisyen</DialogTitle>
            <DialogContent>
                <TextField onChange={onFormInputChange} name="name" label="Name" fullWidth></TextField>
                <TextField onChange={onFormInputChange} name="surname" label="Surname" fullWidth></TextField>
                <TextField onChange={onFormInputChange} name="username" label="UserName" fullWidth></TextField>
                <TextField onChange={onFormInputChange} name="password" label="Password" fullWidth></TextField>
            </DialogContent>
            <DialogActions>

                <Button onClick={() => props.close()} color="secondary">Cancel</Button>
                <Button onClick={() => props.addAkademisyen(formState)}>Submit</Button>
            </DialogActions>
        </Dialog>
    );
}