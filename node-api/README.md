# 이미지 업로드 서버

이 프로젝트는 Node.js와 Express를 사용하여 구현된 이미지 업로드 서버입니다. 사용자는 최대 10개의 이미지 파일을 업로드할 수 있으며, 각 파일은 최대 10MB 크기로 제한됩니다.

## 주의 사항

- 업로드된 파일은 서버의 `uploads` 폴더에 저장됩니다.
- 파일 크기 제한과 업로드 가능한 파일 수는 서버 설정에서 조정할 수 있습니다.

## 시작하기 전에

이 서버를 실행하기 전에, Node.js가 시스템에 설치되어 있어야 합니다. Node.js가 설치되어 있지 않다면, [Node.js 공식 웹사이트](https://nodejs.org/)에서 설치할 수 있습니다.

## 설치 방법

1. 프로젝트를 로컬 시스템에 클론하거나 다운로드합니다.

2. 프로젝트 디렉토리로 이동합니다:

   ```bash
   cd node-api
   ```

3. 필요한 npm 패키지를 설치합니다:
   ```bash
   npm install
   ```

## 서버 실행

1. 프로젝트 디렉토리에서 다음 명령어로 서버를 실행합니다:

   ```bash
   node app.js
   ```

2. 서버가 실행되면, `http://localhost:3000`으로 브라우저에서 접속하여 테스트할 수 있습니다.

## 파일 업로드 테스트

1. 브라우저에서 `http://localhost:3000`으로 접속합니다.

2. "이미지 업로드" 페이지에서 이미지 파일을 선택하고 "업로드" 버튼을 클릭합니다.

3. 업로드된 이미지는 `uploads` 폴더에 저장됩니다.

## 구성 요소

- `app.js`: 서버의 주요 애플리케이션 파일입니다.
- `public/`: 정적 파일(HTML, CSS 등)을 포함하는 폴더입니다.
- `uploads/`: 업로드된 이미지 파일이 저장되는 폴더입니다.

---

# API

## 정적 파일(이미지) 조회

### 요청

- METHOD: `GET`
- PATH : `localhost:3000/uploads/{fileName.png}`
  - `{fileName.png}`: `image-1637927389273.png` 파일명과 확장자의 조합

### 응답

```txt
이미지 파일 그 자체가 응답됩니다.
```

<br>

## 업로드

### 요청

> 여러 파일 업로드 시, 같은 key로 여러개의 이미지를 보내면 됩니다.

- Method: `POST`
- Path : `localhost:3000/uploads`
- Body
  - 형식: multipart/form-data
  - 데이터:
    - key: image
    - value: (업로드할 이미지 파일)

### 응답

- http-status: `201 Created`

```json
{
  "success": true,
  "message": "파일이 정상 업로드 되었습니다.",
  "files": ["filename-123.png", "filename-222.png", "filename-4572.png"]
}
```