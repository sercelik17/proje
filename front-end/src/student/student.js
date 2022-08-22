import React, { useState } from "react";
import {AppBar} from "@mui/material";
import Toolbar from '@mui/material/Toolbar';
import {Avatar} from "@mui/material";
import ListLessons from "../views/lesson/ListLessons";
import {Button} from "@mui/material";

function Student() {
    let lessons, setLessons;
    [lessons, setLessons] = useState([]);
    return(
        <div>
            <AppBar  className="appbar" position="static" color="secondary" >
                <Toolbar>
                    <Button href = "./App" ><Avatar sx={{ width: 32, height: 32, marginLeft: 180}}>S</Avatar></Button>
                </Toolbar>
            </AppBar>
            <ListLessons lessons={lessons}/>
        </div>
    );
}
export default Student;