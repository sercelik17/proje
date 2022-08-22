import React from "react";
import {AppBar} from "@mui/material";
import Toolbar from '@mui/material/Toolbar';
import MenuIcon from '@mui/icons-material/Menu';
import { useState } from "react";
import {MenuItem} from "@mui/material";
import {Button} from "@mui/material";
import {Menu} from "@mui/material";
import {Avatar} from "@mui/material";
import {ButtonGroup} from "@mui/material";
import { NavLink } from "react-router-dom";
import {Grid} from "@mui/material";
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import List from '@mui/material/List';
import Divider from '@mui/material/Divider';




function Admin() {
    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };
    return(
        <div>
            <AppBar  className="appbar" position="static" color="secondary" >
                <Toolbar>
                    <Button
                        id="basic-button"
                        aria-controls={open ? 'basic-menu' : undefined}
                        aria-haspopup="true"
                        aria-expanded={open ? 'true' : undefined}
                        onClick={handleClick}
                    >
                        <MenuIcon />
                    </Button>
                    <Menu
                        id="basic-menu"
                        anchorEl={anchorEl}
                        open={open}
                        onClose={handleClose}
                        MenuListProps={{
                            'aria-labelledby': 'basic-button',
                        }}
                    >
                        <MenuItem onClick={handleClose}>
                            <Button href="./StudentView"> Student</Button>
                        </MenuItem>
                        <MenuItem onClick={handleClose}>
                            <Button href="./AsistanView">Asistan</Button>
                        </MenuItem>
                        <MenuItem onClick={handleClose}>
                            <Button href="./AkademisyenView">Akademisyen</Button>
                        </MenuItem>
                        <MenuItem onClick={handleClose}>
                            <Button href="./LessonView">Lesson</Button>
                        </MenuItem>
                    </Menu>
                    <Button href="./Login"><Avatar sx={{ width: 32, height: 32, marginLeft: 170}}>A</Avatar></Button>
                </Toolbar>
            </AppBar>
            <h1 className="title"> HELLO ADMIN</h1>
            <h2 className="title">Welcome To Admin Panel</h2>
            <Grid paddingTop={20} container spacing={3}>
                <Grid button xs={4} md={4}>
                    <Button className="button" href ="./StudentView">STUDENT</Button>
                </Grid>
                <Grid button xs={4} md={4}>
                    <Button className="button" href ="./AkademisyenView">AKADEMİSYEN</Button>
                </Grid>
                <Grid button xs={4} md={4}>
                    <Button className="button" href ="./AsistanView">ASISTAN</Button>
                </Grid>

            </Grid>
        </div>
    );

}
export default Admin;