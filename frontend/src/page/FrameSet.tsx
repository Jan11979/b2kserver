import './FrameSet.scss';

import React, {useEffect, useState} from "react";

import DrawInfo from "./Info";
import {HeadFrame} from "./HeadFrame";
import {Route, Routes, useLocation, useNavigate, useSearchParams} from "react-router-dom";


function FrameSet() {

    let navigate = useNavigate();
    const location = useLocation();
    useEffect(() => {
        if(searchParams.get('fbtype') === null )
        {
            let navString = "&fbtype=" + "basic" +
                            "&startaddresse=" + "1" +
                            "&faderquantity=" + "12"+
                            "&universe=" + "0" +
                            "&RGBMixer=" + "false";

            navigate({ pathname: location.pathname, search: navString, });
        }
        else {
            navigate({pathname: location.pathname, search: location.search,});
        }
    }, [])

    const [searchParams] = useSearchParams();

    const [reloadFixtureList, setReloadFixtureList] = React.useState(false);
    let tmpActiveFixtureListSelected: string[] = [];
    const [activeFixtureListSelected, setActiveFixtureListSelected] = useState(tmpActiveFixtureListSelected);
    useEffect(() => {
        if(reloadFixtureList){
            setReloadFixtureList(false);
        }
    }, [reloadFixtureList])

    return (
        <div>
            <div>
                <header className="Header">
                    <div>
                        < HeadFrame/>
                    </div>
                </header>
            </div>
            <div className="Body">
                <div className="LeftBody">
                    LeftBody
                </div>
                <div className="MidBody">
                    MidBody
                </div>
                <div className="RightBody">
                    RightBody
                </div>
            </div>
            <div className="BottomBody">
                < DrawInfo />
            </div>
        </div>
    )
}
export default FrameSet;
