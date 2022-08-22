import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import {IconButton} from "@mui/material";
import {Typography} from "@mui/material";
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import {StudentView} from "../students/StudentView";
import {AsistanView} from "../asistan/AsistanView";
import {AkademisyenView} from "../akademisyen/AkademisyenView";

const ResponsiveAppBar = () => {
    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <AppBar position="static" color='success'>
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
                    aria-labelledby="basic-menu-button"
                    anchorEl={anchorEl}
                    open={open}
                    onClose={handleClose}

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
                    <MenuItem onClick={handleClose}>
                        <Button href="./ExamView">Exam</Button>
                    </MenuItem>
                </Menu>
            </Toolbar>
        </AppBar>
    );
};
export default ResponsiveAppBar;