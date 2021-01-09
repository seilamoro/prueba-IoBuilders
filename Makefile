.PHONY: all build test ping-mysql

all: build

up:
	@docker-compose up -d

build:
	@./gradlew build --warning-mode all

run-tests:
	@./gradlew test --warning-mode all

test:
	@docker exec prueba-IoBuilders-java ./gradlew test --warning-mode all

run:
	@./gradlew :run

ping-mysql:
	@docker exec prueba-IoBuilders-mysql mysqladmin --user=root --password= --host "127.0.0.1" ping --silent

# Start the app
start-mooc_backend:
	@./gradlew :run --args='mooc_backend server'

start-backoffice_frontend:
	@./gradlew :run --args='backoffice_frontend server'
