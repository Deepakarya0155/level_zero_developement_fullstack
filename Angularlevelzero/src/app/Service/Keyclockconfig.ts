import { KeycloakService } from 'keycloak-angular';

export function initializeKeycloak(keycloak: KeycloakService) {
    return () =>
      keycloak.init({
        config: {
          url: 'http://localhost:8090/auth',
          realm: 'p2',
          clientId: 'p2c',
        }
        ,
        initOptions:{
            checkLoginIframe:true,
            checkLoginIframeInterval:25
        }
        ,loadUserProfileAtStartUp:true

      });
  }
