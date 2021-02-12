.PHONY: init-local clean-local reset-db build push

DB_SERVICE_NAME=mysql

init-local:
	docker-compose -f infra/local/docker-compose.yml up -d

clean-local:
	docker-compose -f infra/local/docker-compose.yml down

reset-db:
	docker-compose -f infra/local/docker-compose.yml rm -v -s -f $(DB_SERVICE_NAME)
	docker-compose -f infra/local/docker-compose.yml up -d $(DB_SERVICE_NAME)

build: check-env
	./gradlew clean :collector:build
	docker build ./collector -t reaperes/investment-analyser:$(VERSION) -t reaperes/investment-analyser:latest

push: check-env
	docker push reaperes/investment-analyser:$(VERSION)
	docker push reaperes/investment-analyser:latest

check-env:
ifndef VERSION
	$(error VERSION is not set. Must use "make <command> VERSION=xxx")
endif
