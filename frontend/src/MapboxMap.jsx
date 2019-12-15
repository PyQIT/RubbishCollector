import React, {useState, useEffect} from "react";
import ReactMapGL, {Marker, Popup} from "react-map-gl";
import * as rubbishBinDate from "./data/skateboard-parks";
import axios from "axios";
import MyNewComponent from "./MyNewComponent";

export default function App() {
    const [viewport, setViewport] = useState({
        latitude: 50.855956,
        longitude: 20.63,
        width: "150vw",
        height: "150vh",
        zoom: 13
    });


    let rubbishBinDate2 = JSON.parse(localStorage.getItem('rubbishBinDateJSON'));
    //console.log(rubbishBinDate2)

        const [selectedRubbishBin, setSelectedRubbishBin] = useState(null);

        useEffect(() => {
            const listener = e => {
                if (e.key === "Escape") {
                    setSelectedRubbishBin(null);
                }
            };
            window.addEventListener("keydown", listener);

            return () => {
                window.removeEventListener("keydown", listener);
            };
        }, []);


        return (

            <div>
                <MyNewComponent/>
                <ReactMapGL
                    {...viewport}
                    mapboxApiAccessToken={"pk.eyJ1IjoiYmFydHB5IiwiYSI6ImNrMzF2N2duajBjY3Mzbm1qcWIzZXJuN3UifQ.eAi5XtIh9oEMBGhT8vPf_w"}
                    //mapStyle="mapbox://styles/bartpy/ck31wusl310nz1cm2rnf99cn2"
                    mapStyle="mapbox://styles/bartpy/ck32mjdwc0dki1cnynrhy9pbw"
                    onViewportChange={viewport => {
                        setViewport(viewport);
                    }}
                >

                    {rubbishBinDate.features.map(rubbishBin => (
                        <Marker
                            key={rubbishBin.properties.PARK_ID}
                            latitude={rubbishBin.geometry.coordinates[1]}
                            longitude={rubbishBin.geometry.coordinates[0]}
                        >
                            <button
                                className="marker-btn"
                                onClick={e => {
                                    e.preventDefault();
                                    setSelectedRubbishBin(rubbishBin);
                                }}
                            >
                                <img src="full-trash-container.svg" alt="Rubbish Collector Icon"/>
                            </button>
                        </Marker>
                    ))}

                    {selectedRubbishBin ? (
                        <Popup
                            latitude={selectedRubbishBin.geometry.coordinates[1]}
                            longitude={selectedRubbishBin.geometry.coordinates[0]}
                            onClose={() => {
                                setSelectedRubbishBin(null);
                            }}
                        >
                            <div>
                                <h2>{selectedRubbishBin.properties.NAME}</h2>
                                <p>{selectedRubbishBin.properties.FACILITY_F}</p>
                                <p>{selectedRubbishBin.properties.DESCRIPTIO}</p>
                                <p>{selectedRubbishBin.properties.FACILITY}</p>
                                <p>{selectedRubbishBin.properties.PICTURE_LI}</p>
                                <p>{selectedRubbishBin.properties.DESCRIPT_1}</p>
                            </div>
                        </Popup>
                    ) : null}
                </ReactMapGL>
            </div>
        );
    };