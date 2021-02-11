DB_SERVICE_NAME=db

init-local:
	docker-compose -f infra/docker-compose.yml up -d

clean-local:
	docker-compose -f infra/docker-compose.yml down

reset-db:
	docker-compose -f infra/docker-compose.yml rm -v -s -f $(DB_SERVICE_NAME)
	docker-compose -f infra/docker-compose.yml up -d $(DB_SERVICE_NAME)

.PHONY: init-local clean-local reset-db
