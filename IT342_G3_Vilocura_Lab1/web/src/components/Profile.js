import React, { useState, useEffect } from "react";
import { Navigate } from "react-router-dom";
import AuthService from "../services/auth.service";
import UserService from "../services/user.service";

const Profile = () => {
    const [currentUser, setCurrentUser] = useState(undefined);
    const [userReady, setUserReady] = useState(false);
    const [fullUserInfo, setFullUserInfo] = useState(null);

    useEffect(() => {
        const user = AuthService.getCurrentUser();

        if (user) {
            setCurrentUser(user);
            setUserReady(true);

            UserService.getUserBoard().then(
                (response) => {
                    setFullUserInfo(response.data);
                },
                (error) => {
                    console.log("Error fetching full user info", error);
                }
            )
        } else {
            setUserReady(false);
        }
    }, []);

    if (!userReady) {
        if (currentUser === null) {
            return <Navigate to="/login" />;
        }
        // Return explicit null or loader while checking
        return null;
    }

    return (
        <div className="container">
            {(userReady && currentUser) ? (
                <div>
                    <header className="jumbotron">
                        <h3>
                            <strong>{currentUser.username}</strong> Profile
                        </h3>
                    </header>
                    <p>
                        <strong>Token:</strong> {currentUser.accessToken.substring(0, 20)} ...{" "}
                        {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
                    </p>
                    <p>
                        <strong>Id:</strong> {currentUser.id}
                    </p>
                    <p>
                        <strong>Email:</strong> {currentUser.email}
                    </p>
                    <strong>Authorities:</strong>
                    <ul>
                        {/* currentUser.roles &&
            currentUser.roles.map((role, index) => <li key={index}>{role}</li>) */}
                        <li>{currentUser.role}</li>
                    </ul>

                    {fullUserInfo && (
                        <div className="mt-4">
                            <h4>Full User Info from Database (Protected Route /api/user/me)</h4>
                            <pre>{JSON.stringify(fullUserInfo, null, 2)}</pre>
                        </div>
                    )}
                </div>
            ) : null}
        </div>
    );
};

export default Profile;
