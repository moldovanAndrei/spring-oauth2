INSERT INTO persistent_client_details (id, client_id, password, authorized_grant_types, scope, access_token_validity_seconds, refresh_token_validity_seconds) 
	values (1, 'client', 'clientSecret', '["password", "refresh_token"]', '["resource-server-read", "resource-server-write"]',300, 1800);
 
INSERT INTO persistent_client_details (id, client_id, password, authorized_grant_types, scope, access_token_validity_seconds, refresh_token_validity_seconds) 
	values (2, 'clientReadOnly', 'clientSecret', '["password", "refresh_token"]', '["resource-server-read"]',300, 1800);
 
INSERT INTO PERSISTENT_USER_DETAILS (id, username, password) values (1, 'andrei', 'secret');