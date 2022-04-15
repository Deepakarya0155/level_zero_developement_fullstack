import { KeycloakService } from 'keycloak-angular';

export function initializeKeycloak(keycloak: KeycloakService) {
    return () =>
      keycloak.init({
        config: {
          url: 'http://localhost:8090/auth',
          realm: 't2',
          clientId: 't22',
        }
        ,
        initOptions:{
            checkLoginIframe:true,
            checkLoginIframeInterval:25
        }
        ,loadUserProfileAtStartUp:true

      });
  }
