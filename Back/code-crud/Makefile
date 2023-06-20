app-build:
	./mvnw package

docker-build:
	docker build -f src/main/docker/Dockerfile.jvm -t rafaelduartes/app-back:latest .

docker-run:
	@make docker-build
	docker run -i --rm -p 8080:8080 rafaelduartes/app-back:latest

docker push:
	docker push rafaelduartes/app-back:latest

kube-apply:
	kubectl apply -f .\src.\main.\kubernetes

kube-delete:
	kubectl delete pods --all
	kubectl delete services --all
	kubectl delete deployments --all
	kubectl delete hpa --all
	kubectl delete replicaset --all
	kubectl delete replicationcontroller --all
	kubectl delete ingress --all

minikube-image-load:
	@make kube-delete
	@make app-build
	@make docker-build
	minikube image load rafaelduartes/app-back:latest
	minikube ssh "docker images | grep app-back"